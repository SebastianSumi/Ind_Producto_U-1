package pe.edu.upeu.demo.controls;

import javafx.beans.property.SimpleDoubleProperty;
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
import pe.edu.upeu.demo.enums.EstadoArea;
import pe.edu.upeu.demo.model.Area;
import pe.edu.upeu.demo.service.InterfaceArea;

@Controller
public class MngAreas {

    @FXML private TextField txtNombre;
    @FXML private TextField txtAdmin;
    @FXML private Label lbPuntaje;
    @FXML private ComboBox<EstadoArea> cbxEstado;
    @FXML private TableView<Area> tableAreas;

    private TableColumn<Area, Number> idCol;
    private TableColumn<Area, String> nombreCol;
    private TableColumn<Area, String> adminCol;
    private TableColumn<Area, Number> puntajeCol;
    private TableColumn<Area, String> estadoCol;
    private TableColumn<Area, Void> opcCol;

    private ObservableList<Area> listaAreas;
    private int indexEdit = -1;

    @Autowired
    private InterfaceArea areaService;

    @FXML
    public void initialize() {
        cbxEstado.getItems().addAll(EstadoArea.values());
        cbxEstado.getSelectionModel().selectFirst();
        lbPuntaje.setText("0.0");
        definirColumnas();
        listarAreas();
    }

    private void definirColumnas() {
        idCol = new TableColumn<>("ID");
        nombreCol = new TableColumn<>("Nombre");
        adminCol = new TableColumn<>("Admin");
        puntajeCol = new TableColumn<>("Puntaje");
        estadoCol = new TableColumn<>("Estado");
        opcCol = new TableColumn<>("Opciones");
        opcCol.setPrefWidth(200);

        tableAreas.getColumns().addAll(idCol, nombreCol, adminCol, puntajeCol, estadoCol, opcCol);
    }

    private void listarAreas() {
        idCol.setCellValueFactory(cellData -> cellData.getValue().getId());
        nombreCol.setCellValueFactory(cellData -> cellData.getValue().getNombre());
        adminCol.setCellValueFactory(cellData -> cellData.getValue().getAdmin());
        puntajeCol.setCellValueFactory(cellData -> cellData.getValue().getPuntajePromedio());
        estadoCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getEstado().toString()));

        agregarBotonesAccion();
        listaAreas = FXCollections.observableArrayList(areaService.findAll());
        tableAreas.setItems(listaAreas);
    }

    @FXML
    private void registrarArea() {
        Area area = new Area(
                new SimpleIntegerProperty(listaAreas.size() + 1),
                new SimpleStringProperty(txtNombre.getText()),
                new SimpleStringProperty(txtAdmin.getText()),
                new SimpleDoubleProperty(Double.parseDouble(lbPuntaje.getText())),
                cbxEstado.getSelectionModel().getSelectedItem(),
                null,
                null,
                null
        );

        if (indexEdit == -1) {
            areaService.save(area);
        } else {
            areaService.update(area, indexEdit);
            indexEdit = -1;
        }

        limpiarFormulario();
        listarAreas();
    }

    private void editarArea(Area a, int index) {
        txtNombre.setText(a.getNombre().get());
        txtAdmin.setText(a.getAdmin().get());
        lbPuntaje.setText(String.valueOf(a.getPuntajePromedio().get()));
        cbxEstado.getSelectionModel().select(a.getEstado());
        indexEdit = index;
    }

    private void eliminarArea(int index) {
        int id = listaAreas.get(index).getId().get();
        areaService.delete(id);
        listarAreas();
    }

    private void limpiarFormulario() {
        txtNombre.clear();
        txtAdmin.clear();
        lbPuntaje.setText("0.0");
        cbxEstado.getSelectionModel().clearSelection();
    }

    private void agregarBotonesAccion() {
        Callback<TableColumn<Area, Void>, TableCell<Area, Void>> cellFactory = param -> new TableCell<>() {
            private final Button btnEdit = new Button("Editar");
            private final Button btnDelete = new Button("Eliminar");

            {
                btnEdit.setOnAction(event -> {
                    Area area = getTableView().getItems().get(getIndex());
                    editarArea(area, getIndex());
                });
                btnDelete.setOnAction(event -> eliminarArea(getIndex()));
            }

            @Override
            public void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    HBox hbox = new HBox(btnEdit, btnDelete);
                    hbox.setSpacing(10);
                    setGraphic(hbox);
                }
            }
        };
        opcCol.setCellFactory(cellFactory);
    }
}
