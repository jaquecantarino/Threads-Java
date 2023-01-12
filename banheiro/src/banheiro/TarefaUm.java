package banheiro;

public class TarefaUm implements Runnable {

	private Banheiro banheiro;

    public TarefaUm(Banheiro banheiro) {
        this.banheiro = banheiro;
    }

    @Override
    public void run() {
        this.banheiro.fazNumeroUm();
    }

}
