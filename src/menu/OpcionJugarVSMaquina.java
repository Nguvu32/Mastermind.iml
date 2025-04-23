package menu;

import modelo.Mastermind;

public class OpcionJugarVSMaquina extends OpcionMastermind {

    public OpcionJugarVSMaquina(Mastermind mastermind) {
        super("Jugar contra la maquina",mastermind);
    }

    @Override
    public void interactuar() {
        mastermind.jugarVSmaquina();
    }

    @Override
    public String getTitulo() {
        return titulo;
    }
}
