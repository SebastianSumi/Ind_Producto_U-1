package pe.edu.upeu.demo.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum AreaEmpleado {
    ASISGNADO("Asignado"),
    NO_ASIGNADO("No Asignado"),
    EN_PROCESO("En Proceso"),
    INDEPENDIENTE("Independiente");

    private final String descripcion;

    @Override
    public String toString() {
        return descripcion;
    }
}
