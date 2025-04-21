package menu;

import gestor.GestorIO;
import modelo.Mastermind;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String titulo;
    private List<Opcion> opciones;

    public Menu(String titulo) {
        this.titulo = titulo;
        this.opciones = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Opcion> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<Opcion> opciones) {
        this.opciones = opciones;
    }

    public void setOpcion(Opcion opcion){
        opciones.add(opcion);
    }

    public void interactuar() {
        System.out.println(titulo);
        int elegirOpcion = opciones.size() + 1;
        do {
            addOpciones();
            mostrarOpciones();
            try {
                elegirOpcion = elegirOpcion();
                opciones.get(elegirOpcion).interactuar();
            } catch (Exception e) {
                do {
                    System.out.println("Has elegido una opción que no es posible, vuelve a elegir las opciones");
                    mostrarOpciones();
                    elegirOpcion = elegirOpcion();
                    opciones.get(elegirOpcion).interactuar();
                }while (elegirOpcion < 1 && opciones.size() < elegirOpcion);
            }
        }while(elegirOpcion == opciones.size());
    }

    private void eliminarOpciones() {
        opciones.clear();
    }

    public boolean opcionSalir(){
        return true;
    }

    private void addOpciones() {
        opciones.add(new OpcionJugarVSJugador(new Mastermind(2)));
        opciones.add(new OpcionJugarVSMaquina(new Mastermind(1)));
        opciones.add(new OpcionSalir());
    }

    private void mostrarOpciones(){
        for (int i = 0; i < opciones.size(); i++) {
            new GestorIO().outln((i + 1) + ". " + opciones.get(i).getString());
        }
    }

    private int elegirOpcion() {
        int resultado;
        boolean elegido = false;
        GestorIO gestorIO = new GestorIO();
        do {
            gestorIO.outln("Elige una opcion del 1 al " + opciones.size() + ": ");
            resultado = gestorIO.inInt();
            if (resultado - 1 < opciones.size()) {
                elegido = true;
            } else {
                System.out.println("Elige una opcion correcta");
            }
        } while (!elegido);
        return resultado - 1;
    }


}
