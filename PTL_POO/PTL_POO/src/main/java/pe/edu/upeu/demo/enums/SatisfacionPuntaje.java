package pe.edu.upeu.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SatisfacionPuntaje {
    MUY_BAJO(1, "Muy Bajo"),
    BAJO(2, "Bajo"),
    MEDIO(3, "Medio"),
    ALTO(4, "Alto"),
    MUY_ALTO(5, "Muy Alto");

    private final int puntaje;
    private final String descripcion;

    @Override
    public String toString() {
        return " (" + puntaje + " pts)\t" + descripcion;
    }
}
