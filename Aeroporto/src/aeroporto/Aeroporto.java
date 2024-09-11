package aeroporto;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Aeroporto {
    private static final int NUMERO_AERONAVES = 12;
    private static final int MAX_AVIOES_AREA_DECOLAGEM = 2;

    private Semaphore semaforoDecolagem = new Semaphore(MAX_AVIOES_AREA_DECOLAGEM, true);
    private Semaphore[] pistas = {new Semaphore(1, true), new Semaphore(1, true)};

    public void iniciar(View view) {
        Aeronave[] aeronaves = new Aeronave[NUMERO_AERONAVES];
        Random random = new Random();

        for (int i = 0; i < NUMERO_AERONAVES; i++) {
            String nomeAeronave = "Aeronave " + (i + 1);
            String pista = (random.nextBoolean()) ? "Norte" : "Sul";
            aeronaves[i] = new Aeronave(nomeAeronave, pista, view);
        }

        for (Aeronave aeronave : aeronaves) {
            new Thread(() -> {
                try {
                    
                    semaforoDecolagem.acquire();

                    
                    int indicePista = aeronave.getPista().equals("Norte") ? 0 : 1;
                    pistas[indicePista].acquire(); 

                    
                    view.exibirIniciarDecolagem(aeronave.getName(), aeronave.getPista());
                    aeronave.start();
                    aeronave.join(); 

                    pistas[indicePista].release(); 
                    semaforoDecolagem.release();   

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}

