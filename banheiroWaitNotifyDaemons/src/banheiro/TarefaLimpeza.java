package banheiro;

public class TarefaLimpeza implements Runnable {

	private Banheiro banheiro;

	public TarefaLimpeza(Banheiro banheiro) {
		this.banheiro = banheiro;
	}

	@Override
	public void run() {
		while(true) {
			this.banheiro.limpar();
			try {
				Thread.sleep(15000);// limpando cada 15s (caso o banheiro esteja sujo (essa verificação acontece
									// dentro do objeto no metodo limpar)
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
