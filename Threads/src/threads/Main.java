package threads;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Cavaleiro[] cavaleiros = {
            new Cavaleiro("Cavaleiro 1"),
            new Cavaleiro("Cavaleiro 2"),
            new Cavaleiro("Cavaleiro 3"),
            new Cavaleiro("Cavaleiro 4")
        };

        View view = new View(); 

        int distanciaCorredor = 2000; 
        int posicaoTocha = 500;
        int posicaoPedra = 1500;

        
        boolean tochaPega = false;
        boolean pedraPega = false;

        while (true) {
            boolean todosChegaram = true;

            for (Cavaleiro cavaleiro : cavaleiros) {
                cavaleiro.andar();
                view.exibirPosicaoCavaleiro(cavaleiro);

                
                if (!tochaPega && cavaleiro.posicao >= posicaoTocha) {
                    cavaleiro.pegarTocha();
                    tochaPega = true;
                    view.exibirTochaPegada(cavaleiro);
                }

                
                if (!pedraPega && cavaleiro.posicao >= posicaoPedra) {
                    cavaleiro.pegarPedra();
                    pedraPega = true;
                    view.exibirPedraPegada(cavaleiro);
                }

                
                if (cavaleiro.posicao < distanciaCorredor) {
                    todosChegaram = false;
                }
            }

            
            if (todosChegaram) {
                break;
            }

            
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        
        boolean[] portas = {true, false, false, false}; 
        embaralharArray(portas);

        for (Cavaleiro cavaleiro : cavaleiros) {
            int escolhaPorta = random.nextInt(4);
            boolean escapou = portas[escolhaPorta];
            view.exibirEscolhaPorta(cavaleiro, escolhaPorta, escapou);
        }
    }

    
    public static void embaralharArray(boolean[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            boolean temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}
