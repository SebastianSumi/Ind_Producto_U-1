package pe.edu.upeu.demo.service;

import org.springframework.stereotype.Service;
import pe.edu.upeu.demo.model.Area;
import pe.edu.upeu.demo.repository.AreaRepository;

import java.util.List;

@Service
public class IMPTarea extends AreaRepository implements InterfaceArea{
    @Override
    public void save(Area area) {
        areas.add(area);
    }

    @Override
    public Area update(Area area, int id) {
        return areas.set(id, area);
    }

    @Override
    public void delete(int id) {
        areas.remove(id);
    }

    @Override
    public Area findById(int id) {
        return areas.get(id);
    }

    @Override
    public List<Area> findAll() {
        if (areas.isEmpty()) {
            return super.findAll();
        }
        return areas;
    }
}
