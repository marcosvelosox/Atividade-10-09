package threads;

public class View {
    public void exibirPosicaoCavaleiro(Cavaleiro cavaleiro) {
        System.out.println(cavaleiro);
    }

    public void exibirTochaPegada(Cavaleiro cavaleiro) {
        System.out.println(cavaleiro.nome + " pegou a tocha!");
    }

    public void exibirPedraPegada(Cavaleiro cavaleiro) {
        System.out.println(cavaleiro.nome + " pegou a pedra brilhante!");
    }

    public void exibirEscolhaPorta(Cavaleiro cavaleiro, int portaEscolhida, boolean escapou) {
        if (escapou) {
            System.out.println(cavaleiro.nome + " escolheu a porta " + (portaEscolhida + 1) + " e escapou!");
        } else {
            System.out.println(cavaleiro.nome + " escolheu a porta " + (portaEscolhida + 1) + " e foi devorado por monstros.");
        }
    }
}
