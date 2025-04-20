package menu;

import gestor.GestorIO;
import modelo.Mastermind;

public class OpcionJugar extends OpcionesMastermind {
    private Mastermind mastermind;
    private String titulo;

    public OpcionJugar(Mastermind mastermind) {
        this.mastermind = mastermind;
        titulo = "Jugar";
    }

    public String getString() {
        return titulo;
    }

    @Override
    public void interactuar() {
        GestorIO gestorIO = new GestorIO();
        Menu menu = new Menu("Elige una de las siguientes opciones para empezar la partida: ");
        menu.getOpciones().add(new OpcionJugarVSMaquina(mastermind));
        menu.getOpciones().add(new OpcionJugarVSJugador(mastermind));
        menu.getOpciones().add(new OpcionSalir());
        menu.interactuar();
    }
}
