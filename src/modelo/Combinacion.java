package modelo;

import java.util.*;

public class Combinacion {
    private List<Ficha> fichas;

    public Combinacion() {
        Random aleatorio = new Random();
        int numeroAleatorio1 = aleatorio.nextInt(5);
        int numeroAleatorio2 = aleatorio.nextInt(4);
        fichas = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            fichas.add(Ficha.values()[i]);
        }
        fichas.remove(numeroAleatorio1);
        fichas.remove(numeroAleatorio2);
    }

    public Combinacion(List<Ficha> fichas) {
        this.fichas = fichas;
    }

    public List<Ficha> getCombinacion() {
        return fichas;
    }

    public void setCombinacion(List<Ficha> combinacion) {
        this.fichas = combinacion;
    }

    public void aleatoria() {
        Collections.shuffle(fichas);
    }

    public void mostrar() {
        for (int i = 0; i < fichas.size(); i++) {
            if (i == fichas.size() - 1){
                System.out.println("[" + fichas.get(i) + "]");
            }else {
                System.out.print("[" + fichas.get(i) + "], ");
            }

        }
    }
}
