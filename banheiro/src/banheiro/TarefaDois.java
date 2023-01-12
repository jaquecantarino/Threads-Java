package banheiro;

public class TarefaDois implements Runnable {

	private Banheiro banheiro;

    public TarefaDois(Banheiro banheiro) {
        this.banheiro = banheiro;
    }

    @Override
    public void run() {
        this.banheiro.fazNumeroDois();
    }
}
