package pe.edu.upeu.demo.repository;

import pe.edu.upeu.demo.model.Flujo;

import java.util.ArrayList;
import java.util.List;

public class FlujoRepository {

    protected List<Flujo> flujos = new ArrayList<>();

    public List<Flujo> findAll() {
        return flujos;
    }
}
