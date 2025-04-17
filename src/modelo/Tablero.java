package modelo;

import java.util.ArrayList;
import java.util.List;

public class Tablero {
    private Combinacion[] combinacionesPropuestas;
    private Combinacion combinacionSecreta;
    private int intento;
    private final int FILAS_COMBINACIONES_MAX = 10;

    public Tablero(Combinacion combinacionSecreta){
        combinacionesPropuestas = new Combinacion[10];
        List<Ficha> combinacionVacia = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            combinacionVacia.add(Ficha.NADA);
        }
        for (int i = 0; i < FILAS_COMBINACIONES_MAX; i++) {
            combinacionesPropuestas[i] = new Combinacion(combinacionVacia);
        }
        this.combinacionSecreta = combinacionSecreta;
        intento = 0;
    }

    public Combinacion[] getCombinacionesPropuestas() {
        return combinacionesPropuestas;
    }

    public void setCombinacionPropuesta(List<Ficha> combinacionPropuesta) {
        combinacionesPropuestas[intento].setCombinacion(combinacionPropuesta);
        intento++;
    }

    public Combinacion getCombinacionSecreta() {
        return combinacionSecreta;
    }

    public void setCombinacionSecreta(Combinacion combinacionSecreta) {
        this.combinacionSecreta = combinacionSecreta;
    }

    public int getIntento() {
        return intento;
    }

    public void setIntento(int intento) {
        this.intento = intento;
    }

    public int getFILAS_COMBINACIONES_MAX() {
        return FILAS_COMBINACIONES_MAX;
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

    public List<Ficha> compararConSecreta() {
        List<Ficha> resultado = new ArrayList<>();
        for (int i = 0; i < combinacionesPropuestas[intento - 1].getCombinacion().size(); i++) {
            if (negro(i)){
                resultado.add(Ficha.NEGRO);
            } else {
                if (blanco(i)){
                    resultado.add(Ficha.BLANCO);
                } else {
                    resultado.add(Ficha.NADA);
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
        System.out.println("Combinación Secreta -->[" + Ficha.SECRETO + "], [" + Ficha.SECRETO + "], [" + Ficha.SECRETO + "], [" + Ficha.SECRETO + "]");
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
