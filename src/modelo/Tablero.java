package modelo;

import java.util.ArrayList;
import java.util.List;

public class Tablero {
    private Combinacion[] combinacionesPropuestas;
    private Combinacion combinacionSecreta;
    private int intento;

    public Tablero(Combinacion combinacionSecreta){
        combinacionesPropuestas = new Combinacion[10];
        this.combinacionSecreta = combinacionSecreta;
        intento = 0;
    }

    public void setCombinacionPropuesta(List<Color> combinacionPropuesta) {
        combinacionesPropuestas[intento].setCombinacion(combinacionPropuesta);
        intento++;
    }

    public int getIntento() {
        return intento;
    }

    public boolean blanco(int posicion){
        int i = 0;
        boolean encontrado = false;
        while (i < combinacionesPropuestas[intento - 1].getCombinacion().size() && !encontrado) {
            if (combinacionSecreta.getCombinacion().get(i).equals(combinacionesPropuestas[intento - 1].getCombinacion().get(posicion)) && !negro(i)){
                encontrado = true;
            } else {
                i++;
            }
        }

        return encontrado;
    }

    public boolean negro(int posicion){
        return combinacionesPropuestas[intento - 1].getCombinacion().get(posicion).name().equals(combinacionSecreta.getCombinacion().get(posicion).name());
    }

    public boolean igual() {
        int contador = 0;
        for (int i = 0; i < combinacionesPropuestas[intento - 1].getCombinacion().size(); i++) {
            if (negro(i)) {
                contador++;
            }
        }
        return combinacionesPropuestas[intento - 1].getCombinacion().size() == contador;
    }

    public List<String> compararConSecreta() {
        List<String> resultado = new ArrayList<>();
        for (int i = 0; i < combinacionesPropuestas[intento - 1].getCombinacion().size(); i++) {
            if (negro(i)){
                resultado.add("NEGRO");
            } else {
                if (blanco(i)){
                    resultado.add("BLANCO");
                } else {
                    resultado.add("NADA");
                }
            }
        }
        return resultado;
    }

    public void mostrar(){
        System.out.println("---------------TABLERO---------------");
        if (intento == 0){
            System.out.println("---- No hay intentos disponibles todavía ----");
        }
        for (int i = 0; i < intento; i++) {
            System.out.print("Intento número " + (i + 1) + "--> ");
            combinacionesPropuestas[i].mostrar();
        }
        System.out.println("Combinación Secreta -->[SERETO], [SERETO], [SERETO], [SERETO]");
    }

    public Combinacion getCombinacionPropuesta() {
        return combinacionesPropuestas[intento - 1];
    }

    public void mostrarSecreta() {
        System.out.println("---------------TABLERO---------------");
        for (int i = 0; i < intento; i++) {
            System.out.print("Intento número " + (i + 1) + "--> ");
            combinacionesPropuestas[i].mostrar();
        }
        System.out.println("\n La combinación secreta era:");
        combinacionSecreta.mostrar();
    }
}
