package pe.edu.upeu.demo.service;

import org.springframework.stereotype.Service;
import pe.edu.upeu.demo.model.Empleado;
import pe.edu.upeu.demo.repository.EmpleadoRepository;

import java.util.List;

@Service
public class IMPEmpleado extends EmpleadoRepository implements InterfaceEmpleado{
    @Override
    public void save(Empleado empleado) {
        empleados.add(empleado);
    }

    @Override
    public Empleado update(Empleado empleado, int id) {
        return empleados.set(id, empleado);
    }

    @Override
    public void delete(int id) {
        empleados.remove(id);
    }

    @Override
    public Empleado findById(int id) {
        return empleados.get(id);
    }

    @Override
    public List<Empleado> findAll() {
        if (empleados.isEmpty()) {
            return super.findAll();
        }
        return empleados;
    }
}
