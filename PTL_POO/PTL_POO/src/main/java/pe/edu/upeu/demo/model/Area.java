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
import java.util.List;

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
    private List<Tarea> tareas = new ArrayList<>();
    private List<Empleado> empleados = new ArrayList<>();
    private List<Observacion> observaciones = new ArrayList<>();
}