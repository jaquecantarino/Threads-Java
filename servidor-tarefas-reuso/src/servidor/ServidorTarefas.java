package servidor;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorTarefas {

	public static void main(String[] args) throws Exception {
		
		System.out.println("---Iniciando Servidor---");
		ServerSocket servidor = new ServerSocket(13613);
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		
		while(true) { 
			Socket socket = servidor.accept();
			System.out.println("Aceitando novo cliente na porta: " + socket.getPort());
			
			DistribuirTarefas distribuirTarefas = new DistribuirTarefas(socket);
			threadPool.execute(distribuirTarefas);		
		}
		
		
	}
	
	/*
	 * O que � um Socket?
	* J� sabemos que vamos utilizar o TCP e que precisamos do IP da m�quina servidora e a porta. Todos esses detalhes do protocolo s�o abstra�dos no mundo Java atrav�s de um socket. Um socket � o ponto-final de um fluxo de comunica��o entre duas aplica��es, atrav�s de uma rede. � exatamente isso que estamos procurando!
	*/
	
	/* Assim temos o numero fixo de threads disponiveis, podemos fazer de uma outra forma, n�o limitando a quantidade de threads que teremos, assim n�o ficaremos limitados. Basta usar newCachedThreadPool() no lugar do newfixedThreadPool(n) na instancia.
	 * Ficando assim: ExecutorService nomex = Executors.newCachedThreadPool();
	 */
	
	/*
	 * pool de threads = � um gerenciador de objetos do tipo thread, que � capaz de limitar a quantidade de threads al�m de fazer um reaproveitamento das mesmas.
	 */
	
	/* Tipos de Threads Pool: 
	 * A newFixedThreadPool � o pool de threads em que definimos previamente a quantidade de threads que queremos utilizar.
	 * A newCachedThreadPool � o pool de threads que cresce dinamicamente de acordo com as solicita��es. � ideal quando n�o sabemos o n�mero exato de quantas threads vamos precisar.
	 * A newSingleThreadExecutor � o pool de threads que s� permite uma �nica thread.
	 */
	
	/*
	 * A classe Thread possui um m�todo est�tico getAllStackTraces que devolve um conjunto com todas as threads da JVM.
	 * CODIGO:
	 * Set<Thread> todasAsThreads = Thread.getAllStackTraces().keySet();
		for (Thread thread : todasAsThreads) {
    	System.out.println(thread.getName());
		}
	 */

}
