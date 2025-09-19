package pe.edu.upeu.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum EstadoJustificacion {
    PENDIENTE("Pendiente"),
    ACEPTADO("Aceptado"),
    RECHAZADO("Rechazado");

    private final String descripcion;

    @Override
    public String toString() {
        return descripcion;
    }
}
