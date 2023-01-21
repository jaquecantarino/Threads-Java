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
	 * O que é um Socket?
	* Já sabemos que vamos utilizar o TCP e que precisamos do IP da máquina servidora e a porta. Todos esses detalhes do protocolo são abstraídos no mundo Java através de um socket. Um socket é o ponto-final de um fluxo de comunicação entre duas aplicações, através de uma rede. É exatamente isso que estamos procurando!
	*/
	
	/* Assim temos o numero fixo de threads disponiveis, podemos fazer de uma outra forma, não limitando a quantidade de threads que teremos, assim não ficaremos limitados. Basta usar newCachedThreadPool() no lugar do newfixedThreadPool(n) na instancia.
	 * Ficando assim: ExecutorService nomex = Executors.newCachedThreadPool();
	 */
	
	/*
	 * pool de threads = é um gerenciador de objetos do tipo thread, que é capaz de limitar a quantidade de threads além de fazer um reaproveitamento das mesmas.
	 */
	
	/* Tipos de Threads Pool: 
	 * A newFixedThreadPool é o pool de threads em que definimos previamente a quantidade de threads que queremos utilizar.
	 * A newCachedThreadPool é o pool de threads que cresce dinamicamente de acordo com as solicitações. É ideal quando não sabemos o número exato de quantas threads vamos precisar.
	 * A newSingleThreadExecutor é o pool de threads que só permite uma única thread.
	 */
	
	/*
	 * A classe Thread possui um método estático getAllStackTraces que devolve um conjunto com todas as threads da JVM.
	 * CODIGO:
	 * Set<Thread> todasAsThreads = Thread.getAllStackTraces().keySet();
		for (Thread thread : todasAsThreads) {
    	System.out.println(thread.getName());
		}
	 */

}
