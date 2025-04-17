package modelo;

public enum Ficha {
    ROJO, VERDE, AZUL, MORADO, NARANJA, GRIS, BLANCO, NEGRO, NADA, SECRETO;

    public String mostrar() {
        return this.name();
    }
}
