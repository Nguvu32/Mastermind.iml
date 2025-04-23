package modelo;

public enum Color {
    ROJO, VERDE, AZUL, MORADO, NARANJA, GRIS;

    public String mostrar() {
        return this.name();
    }
}
