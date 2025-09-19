package pe.edu.upeu.demo.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upeu.demo.enums.EstadoTarea;
import pe.edu.upeu.demo.enums.Observacion;
import pe.edu.upeu.demo.enums.SatisfacionPuntaje;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
@Setter
public class Tarea {
    private IntegerProperty id;
    private StringProperty nombre;
    private StringProperty descripcion;
    private IntegerProperty num_participantes;
    private Area area;
    private StringProperty fecha_inicio;
    private StringProperty fecha_fin;
    private StringProperty duracion;
    private ArrayList<Empleado> participantes;
    private ArrayList<Observacion> observaciones;
    private SatisfacionPuntaje puntaje;
    private EstadoTarea estado;
}
