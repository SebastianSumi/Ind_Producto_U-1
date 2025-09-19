package pe.edu.upeu.demo.service;

import org.springframework.stereotype.Service;
import pe.edu.upeu.demo.model.Flujo;
import pe.edu.upeu.demo.repository.FlujoRepository;

import java.util.List;

@Service
public class IMPFlujo extends FlujoRepository
implements InterfaceFlujo{

    @Override
    public void save(Flujo flujo) {
        flujos.add(flujo);
    }

    @Override
    public Flujo update(Flujo flujo, int id) {
        return flujos.set(id, flujo);
    }

    @Override
    public void delete(int id) {
        flujos.remove(id);
    }

    @Override
    public Flujo findById(int id) {
        return flujos.get(id);
    }

    @Override
    public List<Flujo> findAll() {
        if (flujos.isEmpty()) {
            return super.findAll();
        }
        return flujos;
    }
}
