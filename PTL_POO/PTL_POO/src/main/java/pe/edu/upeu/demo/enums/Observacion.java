package pe.edu.upeu.demo.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Observacion {
    NO_JUSTIFICADO("No Justificado"),
    JUSTIFICADO("Justificado"),
    NO_TERMINADO("Trabajo No Terminado"),
    INCOMPLETO("Trabajo Incompleto"),
    ERRONEO("Trabajo Erroneo"),
    TARDANZA("Tardanza"),
    OTRO("Otro");

    private final String descripcion;

    @Override
    public String toString() {
        return descripcion;
    }
}
