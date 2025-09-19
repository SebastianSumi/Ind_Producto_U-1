package pe.edu.upeu.demo.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EstadoFlujo {
    PLANIFICACION("En Planificacion"),
    EN_PROGRESO("En Progreso"),
    REVISION("En Revision"),
    FINALIZADO("Finalizado"),
    CANCELADO("Cancelado");

    private final String descripcion;

    @Override
    public String toString() {
        return descripcion;
    }
}
