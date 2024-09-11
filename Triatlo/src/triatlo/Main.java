package triatlo;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        View view = new View();
        Triatlo triatlo = new Triatlo();
        triatlo.iniciar(view);
    }
}
