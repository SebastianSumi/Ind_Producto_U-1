package pe.edu.upeu.demo.repository;

import pe.edu.upeu.demo.model.Tarea;

import java.util.ArrayList;
import java.util.List;

public class TareaRepository {

    protected List<Tarea> tareas = new ArrayList<>();

    public List<Tarea> findAll() {
        return tareas;
    }
}
