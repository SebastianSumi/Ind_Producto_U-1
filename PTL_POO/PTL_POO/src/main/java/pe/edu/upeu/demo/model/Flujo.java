package pe.edu.upeu.demo.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upeu.demo.enums.EstadoFlujo;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
@Setter
public class Flujo {
    private IntegerProperty id;
    private StringProperty nombre;
    private ArrayList<Tarea> tareas;
    private EstadoFlujo estado;
    private StringProperty fecha_creacion;
    private StringProperty fecha_finalizacion;
    private ArrayList<Area> areas;
}
