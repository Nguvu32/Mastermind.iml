package modelo;

import gestor.GestorIO;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private Combinacion combinacion;

    public Jugador(){
        combinacion = new Combinacion();
    }

    public void toOpciones(List<Ficha> lista){
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i+1) + ".[" + lista.get(i) + "]");
        }
    }

    public List<Ficha> juega() {
        List<Ficha> posiblesColores = new ArrayList<>();
        int contador = 0;
        for (int i = 0; i < 6; i++) {
            posiblesColores.add(Ficha.values()[i]);
        }
        List<Ficha> resultado = new ArrayList<>();
        GestorIO gestorIO = new GestorIO();
        do {
            gestorIO.outln("Elige una de las siguientes opciones:");
            toOpciones(posiblesColores);
            int respuesta = gestorIO.inInt() - 1;
            try {
                resultado.add(posiblesColores.get(respuesta));
                posiblesColores.remove(respuesta);
                contador++;
            }catch (Exception e){
                System.out.println("Esa opcion no esta dentro de las posibles, mira bien las opciones que tienes y elige.");
            }
        }while (contador < 4);
        return resultado;
    }

    public List<Ficha> eligeCominacionSecreta() {
        return juega();
    }

    public void celebracion() {
        System.out.println("Yujuuuuu has ganado!");
    }


}
