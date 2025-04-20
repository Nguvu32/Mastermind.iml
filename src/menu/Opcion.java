package menu;

import modelo.Mastermind;

public abstract class Opcion {
    private String titulo;
    private Mastermind mastermind;

    public abstract void interactuar();
    public abstract String getString();
}
