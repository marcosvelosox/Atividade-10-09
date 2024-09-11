package aeroporto;

public class View {
    public void exibirIniciarDecolagem(String nomeAeronave, String pista) {
        System.out.println(nomeAeronave + " iniciou decolagem na pista " + pista);
    }

    public void exibirFase(String nomeAeronave, String fase, int duracao) {
        System.out.println(nomeAeronave + " está na fase " + fase + " por " + duracao + " ms");
    }

    public void exibirConclusao(String nomeAeronave, String pista) {
        System.out.println(nomeAeronave + " concluiu a decolagem na pista " + pista);
    }
}
