package menu;

import modelo.Mastermind;

public class OpcionJugarVSJugador extends OpcionesMastermind {
    private Mastermind mastermind;
    private String titulo;

    public OpcionJugarVSJugador(Mastermind mastermind) {
        this.mastermind = mastermind;
        titulo = "Jugar contra otro jugador";
    }

    public String getString() {
        return titulo;
    }

    @Override
    public void interactuar() {
        mastermind.jugar();
    }
}
