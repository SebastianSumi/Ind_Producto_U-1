package pe.edu.upeu.demo.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EstadoEmpleado {
    DISPONIBLE("Disponible"),
    OCUPADO("Ocupado"),
    SUSPENDIDO("Suspendido"),
    LICENCIA("Licencia"),
    VACACIONES("Vacaciones"),
    RETIRADO("Retirado");

    private final String descripcion;

    @Override
    public String toString() {
        return descripcion;
    }
}
