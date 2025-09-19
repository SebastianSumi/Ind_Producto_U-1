package pe.edu.upeu.demo.service;

import org.springframework.stereotype.Service;
import pe.edu.upeu.demo.model.Justificacion;
import pe.edu.upeu.demo.repository.JustificacionRepository;

import java.util.List;

@Service
public class IMPJustificacion extends JustificacionRepository implements InterfaceJustificacion{
    @Override
    public void save(Justificacion justificacion) {
        justificaciones.add(justificacion);
    }

    @Override
    public Justificacion update(Justificacion justificacion, int id) {
        return justificaciones.set(id, justificacion);
    }

    @Override
    public void delete(int id) {
        justificaciones.remove(id);
    }

    @Override
    public Justificacion findById(int id) {
        return justificaciones.get(id);
    }

    @Override
    public List<Justificacion> findAll() {
        if (justificaciones.isEmpty()) {
            return super.findAll();
        }
        return justificaciones;
    }
}
