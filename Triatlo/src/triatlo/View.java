package triatlo;

import java.util.List;

public class View {

    public void exibirConclusaoCorrida(String nomeAtleta) {
        System.out.println(nomeAtleta + " concluiu a corrida.");
    }

    public void exibirConclusaoTiros(String nomeAtleta, int pontosTiros) {
        System.out.println(nomeAtleta + " concluiu os tiros com " + pontosTiros + " pontos.");
    }

    public void exibirConclusaoCiclismo(String nomeAtleta) {
        System.out.println(nomeAtleta + " concluiu o ciclismo.");
    }

    public void exibirResultadoFinal(List<Atleta> atletas) {
        System.out.println("\nResultado final:");
        for (Atleta atleta : atletas) {
            System.out.println(atleta.getNome() + ": " + atleta.getPontuacao() + " pontos (Tiros: " + atleta.getPontosTiros() + ")");
        }
    }
}

