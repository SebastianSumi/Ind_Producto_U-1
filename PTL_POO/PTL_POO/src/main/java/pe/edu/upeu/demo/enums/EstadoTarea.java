package pe.edu.upeu.demo.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EstadoTarea {
    PENDIENTE("Pendiente"),
    EN_PROGRESO("En Progreso"),
    COMPLETADA("Completada"),
    CANCELADA("Cancelada");

    private final String descripcion;

    @Override
    public String toString() {
        return descripcion;
    }
}
