package menu;

public class OpcionSalir extends Opcion {

    public OpcionSalir() {
        super("Salir");
    }

    @Override
    public void interactuar() {
        System.out.println("Perfecto, nos vemos en la próxima!");
    }

    @Override
    public String getTitulo() {
        return titulo;
    }
}
