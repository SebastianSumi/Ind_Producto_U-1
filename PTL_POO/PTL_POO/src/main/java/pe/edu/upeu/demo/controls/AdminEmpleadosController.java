package pe.edu.upeu.demo.controls;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.edu.upeu.demo.model.Empleado;
import pe.edu.upeu.demo.service.InterfaceEmpleado;

@Controller
public class AdminEmpleadosController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtEmail;
    @FXML private TableView<Empleado> tableEmpleados;

    ObservableList<Empleado> empleados;

    @Autowired
    private InterfaceEmpleado empleadoService;

    private TableColumn<Empleado, Number> idCol;
    private TableColumn<Empleado, String> nombreCol;
    private TableColumn<Empleado, String> apellidoCol;
    private TableColumn<Empleado, String> telefonoCol;
    private TableColumn<Empleado, String> emailCol;
    private TableColumn<Empleado, Void> opcCol;

    private int indexEdit = -1;

    @FXML
    public void initialize() {
        definirColumnas();
        listarEmpleados();
    }

    public void definirColumnas() {
        idCol = new TableColumn<>("ID");
        nombreCol = new TableColumn<>("Nombre");
        apellidoCol = new TableColumn<>("Apellido");
        telefonoCol = new TableColumn<>("Teléfono");
        emailCol = new TableColumn<>("Email");
        opcCol = new TableColumn<>("Opciones");
        opcCol.setPrefWidth(200);

        tableEmpleados.getColumns().addAll(idCol, nombreCol, apellidoCol, telefonoCol, emailCol, opcCol);
    }

    public void listarEmpleados() {
        idCol.setCellValueFactory(cellData -> cellData.getValue().getId());
        nombreCol.setCellValueFactory(cellData -> cellData.getValue().getNombre());
        apellidoCol.setCellValueFactory(cellData -> cellData.getValue().getApellidoPaterno());
        telefonoCol.setCellValueFactory(cellData -> cellData.getValue().getTelefono());
        emailCol.setCellValueFactory(cellData -> cellData.getValue().getEmail());

        agregarBotonesAccion();
        empleados = FXCollections.observableArrayList(empleadoService.findAll());
        tableEmpleados.setItems(empleados);
    }

    public void registrarEmpleado() {
        Empleado e = new Empleado(
                new SimpleIntegerProperty(empleados.size() + 1),
                new SimpleStringProperty(txtNombre.getText()),
                new SimpleStringProperty(txtApellido.getText()),
                null, // apellidoMaterno opcional
                new SimpleStringProperty(txtTelefono.getText()),
                new SimpleStringProperty(txtEmail.getText())
        );

        if (indexEdit == -1) {
            empleadoService.save(e);
        } else {
            empleadoService.update(e, indexEdit);
            indexEdit = -1;
        }

        limpiarFormulario();
        listarEmpleados();
    }

    public void editarEmpleado(Empleado e, int index) {
        txtNombre.setText(e.getNombre().get());
        txtApellido.setText(e.getApellidoPaterno().get());
        txtTelefono.setText(e.getTelefono().get());
        txtEmail.setText(e.getEmail().get());
        indexEdit = index;
    }

    public void eliminarEmpleado(int index) {
        int id = empleados.get(index).getId().get();
        empleadoService.delete(id);
        listarEmpleados();
    }

    public void limpiarFormulario() {
        txtNombre.clear();
        txtApellido.clear();
        txtTelefono.clear();
        txtEmail.clear();
    }

    private void agregarBotonesAccion() {
        Callback<TableColumn<Empleado, Void>, TableCell<Empleado, Void>> cellFactory = param -> new TableCell<>() {
            private final Button btnEdit = new Button("Editar");
            private final Button btnDelete = new Button("Eliminar");

            {
                btnEdit.setOnAction(event -> {
                    Empleado e = getTableView().getItems().get(getIndex());
                    editarEmpleado(e, getIndex());
                });
                btnDelete.setOnAction(event -> eliminarEmpleado(getIndex()));
            }

            @Override
            public void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    HBox box = new HBox(btnEdit, btnDelete);
                    box.setSpacing(10);
                    setGraphic(box);
                }
            }
        };
        opcCol.setCellFactory(cellFactory);
    }
}
