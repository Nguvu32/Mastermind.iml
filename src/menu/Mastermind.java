package menu;

import modelo.Combinacion;
import modelo.Ficha;
import modelo.Jugador;
import modelo.Tablero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mastermind {
    private List<Jugador> jugadores = new ArrayList<>();
    private final int NUMERO_INTENTOS = 10;
    private Tablero tablero;
    private final Ficha[] FICHAS_COMBINACION = new Ficha[]{Ficha.ROJO, Ficha.VERDE, Ficha.AZUL, Ficha.MORADO, Ficha.NARANJA, Ficha.GRIS};
    private int numeroJugadores;

    public Mastermind(int numeroJugadores) {
        this.numeroJugadores = numeroJugadores;
        for (int i = 0; i < numeroJugadores; i++) {
            this.jugadores.add(new Jugador());
        }
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(int numero) {
        for (int i = 0; i < numero; i++) {
            jugadores.add(new Jugador());
        };
    }

    public int getNumeroJugadores() {
        return numeroJugadores;
    }

    public void setNumeroJugadores(int numeroJugadores) {
        this.numeroJugadores = numeroJugadores;
    }

    public void mostrarColores(){
        for (int i = 0; i < 6; i++) {
            if (i == 5){
                System.out.print("[" + FICHAS_COMBINACION[i].mostrar() + "]");
            }else {
                System.out.print("[" + FICHAS_COMBINACION[i].mostrar() + "], ");
            }
        }
    }

    public void jugar(){
        boolean ganado = false;
        Combinacion combinacionSecreta;
        Combinacion resultado;
        if (jugadores.size() > 1){
            System.out.println("Has elegido la opción de 2 jugadores. Jugador 1, elige la combinación secreta:");
            combinacionSecreta = new Combinacion(jugadores.get(1).eligeCominacionSecreta());
            System.out.println("La combinación ya ha sido elegida correctamente!");
            tablero = new Tablero(combinacionSecreta);
            tablero.mostrar();
        } else {
            combinacionSecreta = new Combinacion();
            combinacionSecreta.aleatoria();
            System.out.println("La combinación secreta ha sido generada!");
            tablero = new Tablero(combinacionSecreta);
            tablero.mostrar();
        }
        while (!ganado && tablero.getIntento() < NUMERO_INTENTOS){
            System.out.println("modelo.Jugador 2, elige una combinación:");
            tablero.setCombinacionPropuesta(jugadores.get(0).juega());
            if (tablero.igual()){
                tablero.mostrarSecreta();
                jugadores.get(0).celebracion();
                ganado = true;
            } else {
                tablero.mostrar();
                resultado = new Combinacion(tablero.compararConSecreta());
                Collections.sort(resultado.getCombinacion());
                System.out.println("Este ha sido el resultado de tu intento");
                resultado.mostrar();
            }
        }
        if (!ganado){
            System.out.println("Ya has agotado todos los intentos! :(");
        } else {
            System.out.println("El juego ha terminado!!");
        }
    }
}
