package servidor;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.Callable;

public class ComandoC2AcessaBanco implements Callable<String> {

	private PrintStream saida;

	public ComandoC2AcessaBanco(PrintStream saida) {
		this.saida = saida;
	}

	@Override
	public String call() throws Exception {

		System.out.println("-- Servidor recebeu o comando C2--");

		saida.println("--processando comando C2 (Banco)--");
		
		Thread.sleep(20000);
		
		//aqui estamos criando um numero qualquer para somar com um, para que nosso comando tenha algum processamento
		int num = new Random().nextInt(100) + 1;

		System.out.println("Servidor finalizou execução de comando C2!");
		//saida.println("--Comando C2 executado com sucesso!--");
		
		return Integer.toString(num);
	}

}
