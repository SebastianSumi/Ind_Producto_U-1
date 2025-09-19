package pe.edu.upeu.demo.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upeu.demo.enums.AccesoEmpleado;
import pe.edu.upeu.demo.enums.AreaEmpleado;
import pe.edu.upeu.demo.enums.EstadoEmpleado;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
@Setter
public class Empleado {
    private IntegerProperty id;
    private AccesoEmpleado acceso;
    private StringProperty password;
    private StringProperty nombre;
    private StringProperty apellido_paterno;
    private StringProperty apellido_materno;
    private StringProperty telefono;
    private StringProperty email;
    private DoubleProperty salario;
    private EstadoEmpleado estado;
    private AreaEmpleado estado_area;
    private Area area;
    private ArrayList<String> Observaciones;
    private DoubleProperty puntaje_promedio;
}
