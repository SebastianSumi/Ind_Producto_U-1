package pe.edu.upeu.demo.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum AccesoEmpleado {
    MANAGER("Gerente"),
    ADMIN("Administrador"),
    USER ("Usuario");

    private String tipoAcceso;

    @Override
    public String toString() {
        return tipoAcceso;
    }
}
