package triatlo;

import java.util.Random;

public class Atleta extends Thread {
    private String nome;
    private int posicaoCorrida = 0;
    private int pontuacao = 0;
    private int pontosTiros = 0;
    private int posicaoCiclismo = 0;
    private Random random = new Random();
    private View view;
	public Atleta(String nome, View view) {
        this.nome = nome;
		this.view = view;
    }

    
    public void correr() throws InterruptedException {
        while (posicaoCorrida < 3000) {
            int velocidade = 20 + random.nextInt(6); 
            posicaoCorrida += velocidade;
            Thread.sleep(30);
        }
        view.exibirConclusaoCorrida(nome);
    }

   
    public void atirar() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            int pontos = random.nextInt(11); 
            pontosTiros += pontos;
            int tempoTiro = 500 + random.nextInt(2501); 
            Thread.sleep(tempoTiro);
        }
        view.exibirConclusaoTiros(nome, pontosTiros);
    }

    
    public void pedalar() throws InterruptedException {
        while (posicaoCiclismo < 5000) {
            int velocidade = 30 + random.nextInt(11); 
            posicaoCiclismo += velocidade;
            Thread.sleep(40);
        }
        view.exibirConclusaoCiclismo(nome);
    }

    
    @Override
    public void run() {
        try {
            correr(); 
            synchronized (this) {
                wait(); 
            }
            atirar(); 
            pedalar(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getPontuacao() {
        return pontuacao + pontosTiros;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getNome() {
        return nome;
    }

    public int getPontosTiros() {
        return pontosTiros;
    }
}

