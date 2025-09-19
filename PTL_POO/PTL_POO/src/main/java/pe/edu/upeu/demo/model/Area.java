package pe.edu.upeu.demo.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.upeu.demo.enums.EstadoArea;
import pe.edu.upeu.demo.enums.Observacion;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Area {
    private IntegerProperty id;
    private StringProperty nombre;
    private StringProperty admin;
    private DoubleProperty puntajePromedio;
    private EstadoArea estado;
    private ArrayList<Tarea> tareas;
    private ArrayList<Empleado> empleados;
    private ArrayList<Observacion> observaciones;
}