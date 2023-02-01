package servidor;

import java.util.concurrent.BlockingQueue;

public class TarefaConsumir implements Runnable {

	//criando a fila
	private BlockingQueue<String> filaComandos;

	//contrutor
	public TarefaConsumir(BlockingQueue<String> filaComandos) {
		this.filaComandos = filaComandos;
	}

	@Override
	public void run(){
		try {
			String comando = null;
			//enquanto existe um novo comando continua fazendo o consumo
			while ((comando = filaComandos.take()) != null) { //take() bloqueia até que exista um próximo comando para consumir
				System.out.println("Consumindo comando " + comando + ", " + Thread.currentThread().getName());
				Thread.sleep(10000); //demorando 10s para consumir
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
