package menu;

public class OpcionJugarVSMaquina extends OpcionesMastermind {
    private Mastermind mastermind;
    private String titulo;

    public OpcionJugarVSMaquina(Mastermind mastermind) {
        this.mastermind = mastermind;
        titulo = "Jugar contra la maquina";
    }

    public String getString() {
        return titulo;
    }

    @Override
    public void interactuar() {
        mastermind.jugar();
    }
}
