package pe.edu.upeu.demo.service;

import pe.edu.upeu.demo.model.Area;

import java.util.List;

public interface InterfaceArea {
    void save(Area area);
    List<Area> findAll();
    Area update(Area area, int id);
    void delete(int id);

    Area findById(int id);
}
