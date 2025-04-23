package menu;

import modelo.Mastermind;

public abstract class OpcionMastermind extends Opcion {
    protected Mastermind mastermind;

    public OpcionMastermind(String titulo, Mastermind mastermind) {
        super(titulo);
        this.mastermind = mastermind;
    }

    public abstract void interactuar();

    @Override
    public String getTitulo() {
        return titulo;
    }
}
