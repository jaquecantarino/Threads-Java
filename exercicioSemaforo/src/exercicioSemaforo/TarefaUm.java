package exercicioSemaforo;

public class TarefaUm implements Runnable {
	
	private Semaforo semaforo;

	public TarefaUm(Semaforo semaforo) {
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		for(int i=0; i<15; i++) {
			this.semaforo.mudaSemaforo();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
