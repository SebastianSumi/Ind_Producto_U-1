package pe.edu.upeu.demo.service;

import pe.edu.upeu.demo.model.Flujo;

import java.util.List;

public interface InterfaceFlujo {
    void save(Flujo flujo);
    List<Flujo> findAll();
    Flujo update(Flujo flujo, int id);
    void delete(int id);

    Flujo findById(int id);
}
