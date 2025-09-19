package pe.edu.upeu.demo.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upeu.demo.enums.EstadoArea;
import pe.edu.upeu.demo.enums.Observacion;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
@Setter
public class Area {
    private IntegerProperty id;
    private StringProperty nombre;
    private ArrayList<Tarea> tareas;
    private EstadoArea estado;
    private StringProperty admin;
    private ArrayList<Empleado> empleados;
    private double puntaje_promedio;
    private ArrayList<Observacion> observaciones;
}
