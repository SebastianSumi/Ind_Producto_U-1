package pe.edu.upeu.demo.service;

import pe.edu.upeu.demo.model.Empleado;

import java.util.List;

public interface InterfaceEmpleado {
    void save(Empleado empleado);
    List<Empleado> findAll();
    Empleado update(Empleado empleado, int id);
    void delete(int id);

    Empleado findById(int id);
}
