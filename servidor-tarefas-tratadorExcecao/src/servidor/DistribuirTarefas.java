package servidor;

import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.io.IOException;
import java.io.PrintStream;

import javax.management.RuntimeErrorException;

public class DistribuirTarefas implements Runnable {

	private Socket socket;
	private ServidorTarefas servidor;
	private ExecutorService threadPool; //aqui vamos reaproveitar o threadPool já existente no servidor, para não precisar criar um para cada comando.

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
					saidaCliente.println("-Confirmação comando C1-");
					//Como vamos distribuir tarefas nos comandos?
					//Criando classes para cada um deles.
					ComandoC1 c1 = new ComandoC1(saidaCliente);
					this.threadPool.execute(c1);
					break;
				}
				case "c2" : {
					saidaCliente.println("-Confirmação comando C2-");
					ComandoC2 c2 = new ComandoC2(saidaCliente);
					this.threadPool.execute(c2);
					break;
				}
				case "c3" : {
					saidaCliente.println("-Confirmação comando C3-");
					break;
				}
				case "fim" : {
					saidaCliente.println("--Desligando Servidor--");
					servidor.parar();
					break;
				}
				default : {
					saidaCliente.println("Comando não identificado");
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
