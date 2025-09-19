package pe.edu.upeu.demo.repository;

import pe.edu.upeu.demo.model.Justificacion;

import java.util.ArrayList;
import java.util.List;

public class JustificacionRepository {

    protected List<Justificacion> justificaciones = new ArrayList<>();

    public List<Justificacion> findAll() {
        return justificaciones;
    }
}
