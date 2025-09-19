package pe.edu.upeu.demo.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EstadoArea {
    DISPONIBLE("Disponible"),
    LIMITE("Capacidad de carga al límite"),
    MANTENIMIENTO("En Mantenimiento"),
    CERRADO("Cerrada");

    private final String descripcion;

    @Override
    public String toString() {
        return descripcion;
    }
}
