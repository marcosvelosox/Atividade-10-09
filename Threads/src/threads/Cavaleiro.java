package threads;

import java.util.Random;

public class Cavaleiro {
    String nome;
    int posicao = 0;
    int velocidade;
    boolean temTocha = false;
    boolean temPedra = false;

    public Cavaleiro(String nome) {
        this.nome = nome;
        
        this.velocidade = new Random().nextInt(3) + 2;
    }

    public void andar() {
        this.posicao += this.velocidade;
    }

    public void pegarTocha() {
        if (!temTocha) {
            temTocha = true;
            velocidade += 2;
        }
    }

    public void pegarPedra() {
        if (!temPedra && !temTocha) {
            temPedra = true;
            velocidade += 2;
        }
    }

    @Override
    public String toString() {
        return nome + " está na posição " + posicao + "m com velocidade de " + velocidade + "m/50ms";
    }
}
