package menu;

import modelo.Mastermind;

public abstract class OpcionesMastermind extends Opcion {
    private String titulo;
    private Mastermind mastermind;

    public OpcionesMastermind(Mastermind mastermind) {
        this.mastermind = mastermind;
    }

    protected OpcionesMastermind() {
    }

    public abstract String getString();

    public abstract void interactuar();
}
