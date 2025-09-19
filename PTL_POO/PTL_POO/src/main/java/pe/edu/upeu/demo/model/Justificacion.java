package pe.edu.upeu.demo.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upeu.demo.enums.EstadoJustificacion;

@AllArgsConstructor
@Getter
@Setter
public class Justificacion {
    private IntegerProperty id;
    private Empleado empleado;
    private Area area;
    private StringProperty asunto;
    private StringProperty descripcion;
    private StringProperty fecha;
    private EstadoJustificacion estado;
}
