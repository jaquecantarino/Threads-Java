package servidor;

import java.io.PrintStream;

public class ComandoC2 implements Runnable {

	private PrintStream saida;

	//cria construtor obrigatorio
	public ComandoC2(PrintStream saida) {
		this.saida = saida;
	}

	//metodo run de todas as threads
	@Override
	public void run() {
		//o que essa thread vai fazer?
		//1- vai imprimir na tela o comando que est� sendo executado
		System.out.println("--Executando comando C2--"); //isso aqui � a saida pro lado servidor

		//2- vai demorar 10000 milisegundos (try...catch obrigatorio no metodo sleep)
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		
		throw new RuntimeException("exce��o no comando c2!!!!");

		//3- E ent�o vai imprimir depois desse temppo que o comando j� foi executado
		//saida.println("--Comando C2 foi executado--"); //isso aqui � saida pro lado cliente

	}

}
