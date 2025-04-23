package menu;

public abstract class Opcion {
    protected String titulo;

    public Opcion(String titulo){
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public abstract void interactuar();
}
