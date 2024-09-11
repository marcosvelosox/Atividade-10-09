package aeroporto;

import java.util.Random;

public class Aeronave extends Thread {
    private String nome;
    private String pista;
    private View view;
    
    public Aeronave(String nome, String pista, View view) {
        this.nome = nome;
        this.pista = pista;
        this.view = view;
    }

    
    public void decolar() throws InterruptedException {
        Random random = new Random();

        
        int tempoManobra = 300 + random.nextInt(400); 
        view.exibirFase(nome, "Manobra", tempoManobra);
        Thread.sleep(tempoManobra);

        
        int tempoTaxiar = 500 + random.nextInt(500); 
        view.exibirFase(nome, "Taxiar", tempoTaxiar);
        Thread.sleep(tempoTaxiar);

        
        int tempoDecolagem = 600 + random.nextInt(200); 
        view.exibirFase(nome, "Decolagem", tempoDecolagem);
        Thread.sleep(tempoDecolagem);

        
        int tempoAfastamento = 300 + random.nextInt(500); 
        view.exibirFase(nome, "Afastamento", tempoAfastamento);
        Thread.sleep(tempoAfastamento);

        view.exibirConclusao(nome, pista);
    }

    @Override
    public void run() {
        try {
            decolar();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getPista() {
        return pista;
    }
}
