package pe.edu.upeu.demo.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.upeu.demo.enums.EstadoFlujo;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Flujo {
    private IntegerProperty id;
    private StringProperty nombre;
    private List<Tarea> tareas;
    private EstadoFlujo estado;
    private StringProperty fechaCreacion;
    private StringProperty fechaFinalizacion;
    private List<Area> areas;
}