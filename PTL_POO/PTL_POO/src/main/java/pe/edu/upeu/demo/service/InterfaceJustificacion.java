package pe.edu.upeu.demo.service;

import pe.edu.upeu.demo.model.Justificacion;

public interface InterfaceJustificacion {
    void save(Justificacion justificacion);
    java.util.List<Justificacion> findAll();
    Justificacion update(Justificacion justificacion, int id);
    void delete(int id);

    Justificacion findById(int id);
}
