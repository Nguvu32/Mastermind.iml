package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mastermind {
    private List<Jugador> jugadores = new ArrayList<>();
    private final int NUMERO_INTENTOS = 10;
    private Tablero tablero;
    private int numeroJugadores;

    public Mastermind() {
        numeroJugadores = 1;
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
        }
        ;
    }

    public int getNumeroJugadores() {
        return numeroJugadores;
    }

    public void setNumeroJugadores(int numeroJugadores) {
        this.numeroJugadores = numeroJugadores;
    }

    /*
    si mostrarColores() entonces Color es Color
     */

    public void mostrarColores() {
        for (int i = 0; i < 6; i++) {
            if (i == 5) {
                System.out.print("[" + modelo.Color.values()[i] + "]");
            } else {
                System.out.print("[" + modelo.Color.values()[i] + "], ");
            }
        }
    }

    /*
    VARIOS MÉTODOS JUGAR
     */

    public void jugarVSmaquina() {
        boolean ganado = false;
        Combinacion combinacionSecreta = new Combinacion();
        combinacionSecreta.aleatoria();
        System.out.println("La combinación secreta ha sido generada!");
        tablero = new Tablero(combinacionSecreta);
        tablero.mostrar();
        while (!ganado && tablero.getIntento() < NUMERO_INTENTOS) {
            ganado = hasGanado(ganado);
        }
        if (!ganado) {
            System.out.println("Ya has agotado todos los intentos! :(");
            System.out.println("La combinación secreta es:");
            combinacionSecreta.mostrar();
        } else {
            System.out.println("El juego ha terminado!!");
        }
    }

    private boolean hasGanado(boolean ganado) {
        List<String> resultado;
        System.out.println("Jugador 2, elige una combinación:");
        tablero.setCombinacionPropuesta(jugadores.get(0).juega());
        if (tablero.igual()) {
            tablero.mostrarSecreta();
            jugadores.get(0).celebracion();
            ganado = true;
        } else {
            tablero.mostrar();
            resultado = new ArrayList<>(tablero.compararConSecreta());
            Collections.sort(resultado);
            System.out.println("Este ha sido el resultado de tu intento");
            mostrarResultado(resultado);
        }
        return ganado;
    }

    private static void mostrarResultado(List<String> resultado) {
        for (int i = 0; i < resultado.size(); i++) {
            if (i == resultado.size() - 1){
                System.out.println("[" + resultado.get(i) + "]");
            }else {
                System.out.print("[" + resultado.get(i) + "], ");
            }
        }
    }

    public void jugarVSjugador() {
        boolean ganado = false;
        Combinacion combinacionSecreta;
        System.out.println("Has elegido la opción de 2 jugadores. Jugador 1, elige la combinación secreta:");
        combinacionSecreta = new Combinacion(jugadores.get(0).eligeCominacionSecreta());
        System.out.println("La combinación ya ha sido elegida correctamente!");
        tablero = new Tablero(combinacionSecreta);
        tablero.mostrar();
        while (!ganado && tablero.getIntento() < NUMERO_INTENTOS) {
            ganado = hasGanado(ganado);
        }
        if (!ganado) {
            System.out.println("Ya has agotado todos los intentos! :(");
            System.out.println("La combinación secreta es:");
            combinacionSecreta.mostrar();
        } else {
            System.out.println("El juego ha terminado!!");
        }
    }
}
