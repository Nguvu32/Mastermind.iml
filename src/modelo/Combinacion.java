package modelo;

import java.util.*;

public class Combinacion {
    private List<Color> colors;

    public Combinacion() {
        Random aleatorio = new Random();
        int numeroAleatorio1 = aleatorio.nextInt(5);
        int numeroAleatorio2 = aleatorio.nextInt(4);
        colors = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            colors.add(modelo.Color.values()[i]);
        }
        colors.remove(numeroAleatorio1);
        colors.remove(numeroAleatorio2);
    }

    public Combinacion(List<Color> colors) {
        this.colors = colors;
    }

    public List<Color> getCombinacion() {
        return colors;
    }

    public void setCombinacion(List<Color> combinacion) {
        this.colors = combinacion;
    }

    public void aleatoria() {
        Collections.shuffle(colors);
    }

    public void mostrar() {
        for (int i = 0; i < colors.size(); i++) {
            if (i == colors.size() - 1){
                System.out.println("[" + colors.get(i) + "]");
            }else {
                System.out.print("[" + colors.get(i) + "], ");
            }

        }
    }
}
