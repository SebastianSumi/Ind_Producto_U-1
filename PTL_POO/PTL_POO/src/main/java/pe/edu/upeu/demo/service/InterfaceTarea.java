package pe.edu.upeu.demo.service;

import pe.edu.upeu.demo.model.Tarea;

import java.util.List;

public interface InterfaceTarea {
    void save(Tarea tarea);
    List<Tarea> findAll();
    Tarea update(Tarea tarea, int id);
    void delete(int id);

    Tarea findById(int id);

}
