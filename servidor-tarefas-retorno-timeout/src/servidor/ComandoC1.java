package servidor;

import java.io.PrintStream;

public class ComandoC1 implements Runnable {

	private PrintStream saida;

	//cria construtor obrigatorio
	public ComandoC1(PrintStream saida) {
		this.saida = saida;
	}

	//metodo run de todas as threads
	@Override
	public void run() {
		//o que essa thread vai fazer?
		//1- vai imprimir na tela o comando que est� sendo executado
		System.out.println("--Executando comando C1--");

		//2- vai demorar 10000 milisegundos (try...catch obrigatorio no metodo sleep)
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		//3- E ent�o vai imprimir depois desse temppo que o comando j� foi executado
		saida.println("--Comando C1 foi executado--");

	}

}
