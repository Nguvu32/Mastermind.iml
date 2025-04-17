package menu;

public class OpcionSalir extends Opcion {
    String titulo;
    private boolean ejecutar;

    public OpcionSalir() {
        titulo = "Salir";
        ejecutar = false;
    }

    @Override
    public void interactuar() {
        ejecutar = true;
        System.out.println("Perfecto, nos vemos en la próxima!");
    }

    @Override
    public String getString() {
        return titulo;
    }
}
