package menu;

import modelo.Mastermind;

public class OpcionJugarVSJugador extends OpcionMastermind {

    public OpcionJugarVSJugador(Mastermind mastermind) {
        super("Jugar contra un jugador", mastermind);
    }

    @Override
    public void interactuar() {
        mastermind.jugarVSjugador();
    }

    @Override
    public String getTitulo() {
        return titulo;
    }
}
