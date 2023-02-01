package servidor;

import java.io.PrintStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

//Por que criamos essa classe?
//Ela foi necessaria para juntar o resultado do comando C2, que faz duas ações, uma vez que a chamada de get para essa caso seria um bloqueia para exibição dos resultado,
//sendo assim necessario a utilização de uma thread
//como ja temos a threadPool no nosso projeto utilizamos ela, como podemos conferir na linha do DistribuirTarefas
//this.threadPool.submit(new JuntaResultadoWSBanco(futureWs, futureBanco, saidaCliente)); criamos uma nova instancia pro pool onde retorna o resultado dessa classe
public class JuntaResultadoWSBanco implements Runnable {
	
	private Future<String> futureWs;
	private Future<String> futureBanco;
	private PrintStream saidaCliente;

	public JuntaResultadoWSBanco(Future<String> futureWs, Future<String> futureBanco, PrintStream saidaCliente) {
		this.futureWs = futureWs;
		this.futureBanco = futureBanco;
		this.saidaCliente = saidaCliente;
	}

	@Override
	public void run() {
		
		System.out.println("--Aguardando resultado dos Futures--");
		
		//try...catch multi, trata diversas exceções no mesmo bloco, especificadas no catch
		try {
			//aqui estamos atribuindo aos os nossos atributos os retornos das futures, nesse get diferenciado, temos que definir um numero inteiro e em seguido (pós virgula) que tipo de contador, dias, segundos e etc...
			String numWS = this.futureWs.get(15, TimeUnit.SECONDS);
			String numBanco = this.futureBanco.get(15, TimeUnit.SECONDS);
		
			//devolvendo resultado para o cliente
			this.saidaCliente.println("Resultado comando C2: " + numWS + ", " + numBanco);
		
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			System.out.println("-- TimeOut:Cancelando execução do comando C2-- ");
			this.saidaCliente.println("--TimeOut na excecução do comando C2--");
			//caso encontre algum erro cancelara as futures
			this.futureWs.cancel(true);
			this.futureBanco.cancel(true);
		
		}
		
		System.out.println("--JuntaResultadoWSBanco finalizado!--");

	}

}
