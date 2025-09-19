package pe.edu.upeu.demo.controls;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.edu.upeu.demo.enums.EstadoArea;
import pe.edu.upeu.demo.model.Area;
import pe.edu.upeu..demo.model.Empleado;
import pe.edu.upeu.demo.service.InterfaceArea;
import pe.edu.upeu.demo.service.InterfaceEmpleado;

@Controller
public class MngAreas {

    @FXML
    private TextField txt_Nombre;
    @FXML
    private Label lb_Puntaje;
    @FXML
    private TextField txt_Admin;
    @FXML
    private ComboBox<EstadoArea> cbx_Estado;
    @FXML
    private TableView<Area> tview_Areas;
    @FXML
    private  TextField txt_Buscar;
    @FXML
    private Button btn_Buscar;

    @Autowired
    InterfaceArea ia;
    @Autowired
    InterfaceEmpleado ie;

    @FXML
    public void initialize(){
        cbx_Estado.getItems().addAll(EstadoArea.values());
        cbx_Estado.getSelectionModel().select(0);
        lb_Puntaje.setText("0.0");
    }

    @FXML
    public void limpiarFormulario(){
        txt_Nombre.setText("");
        lb_Puntaje.setText("0.0");
        txt_Admin.setText("");
        cbx_Estado.getSelectionModel().clearSelection();
    }

    @FXML void agregarArea(){
        Area area = new Area();
        area.setNombre(new SimpleStringProperty(txt_Nombre.getText()));
        area.setAdmin(new SimpleStringProperty(ie.findAll(txt_Admin.getInteger()).getNombre()));

        area.setPuntaje_promedio(Double.parseDouble(lb_Puntaje.getText()));
        area.setEstado(cbx_Estado.getSelectionModel().getSelectedItem());
        System.out.println(area);
        limpiarFormulario();

    }
}
