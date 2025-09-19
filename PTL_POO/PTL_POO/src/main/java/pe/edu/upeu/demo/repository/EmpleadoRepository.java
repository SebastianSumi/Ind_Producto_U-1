package pe.edu.upeu.demo.repository;

import pe.edu.upeu.demo.model.Empleado;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoRepository {

    protected List<Empleado> empleados = new ArrayList<>();

    public List<Empleado> findAll() {
        return empleados;
    }
}
