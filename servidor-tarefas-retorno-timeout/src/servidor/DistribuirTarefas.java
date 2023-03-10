package servidor;

import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.io.IOException;
import java.io.PrintStream;

import javax.management.RuntimeErrorException;

public class DistribuirTarefas implements Runnable {

	private Socket socket;
	private ServidorTarefas servidor;
	private ExecutorService threadPool; //aqui vamos reaproveitar o threadPool j? existente no servidor, para n?o precisar criar um para cada comando.

	public DistribuirTarefas(ExecutorService threadPool, Socket socket, ServidorTarefas servidor) {
		this.threadPool = threadPool;
		this.socket = socket;
		this.servidor = servidor;
	}

	@Override
	public void run() {
		try {
			System.out.println("Distribuindo tarefas para: " + socket);

			Scanner entradaCliente = new Scanner(socket.getInputStream());
			
			PrintStream saidaCliente = new PrintStream(socket.getOutputStream());

			while(entradaCliente.hasNextLine()) {
				String comando = entradaCliente.nextLine();
				System.out.println("comando recebido: " + comando);
				
				switch(comando) {
				case "c1" : {
					saidaCliente.println("-Confirma??o comando C1-");
					ComandoC1 c1 = new ComandoC1(saidaCliente);
					this.threadPool.execute(c1);
					break;
				}
				case "c2" : {
					saidaCliente.println("-Confirma??o comando C2-");
					ComandoC2ChamaWS c2 = new ComandoC2ChamaWS(saidaCliente);
					ComandoC2AcessaBanco c2Banco = new ComandoC2AcessaBanco(saidaCliente);
					Future<String> futureWs =  this.threadPool.submit(c2);
					Future<String> futureBanco =  this.threadPool.submit(c2Banco);
					
					//String resultadoWS = futureWs.get();
					this.threadPool.submit(new JuntaResultadoWSBanco(futureWs, futureBanco, saidaCliente)); //onde nasce a necessidade de mais uma classe no projeto
					
					break;
				}
				case "c3" : {
					saidaCliente.println("-Confirma??o comando C3-");
					break;
				}
				case "fim" : {
					saidaCliente.println("--Desligando Servidor--");
					servidor.parar();
					break;
				}
				default : {
					saidaCliente.println("Comando n?o identificado");
				}
				}
				
				System.out.println(comando);
			}
			saidaCliente.close();
			entradaCliente.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 

	}

}
