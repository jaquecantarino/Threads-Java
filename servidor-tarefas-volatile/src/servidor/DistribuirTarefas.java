package servidor;

import java.net.Socket;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintStream;

import javax.management.RuntimeErrorException;

public class DistribuirTarefas implements Runnable {

	private Socket socket;
	private ServidorTarefas servidor;

	public DistribuirTarefas(Socket socket, ServidorTarefas servidor) {
		this.socket = socket;
		this.servidor = servidor;
	}

	@Override
	public void run() {
		try {
			System.out.println("Distribuindo tarefas para: " + socket);

			Scanner entradaCliente = new Scanner(socket.getInputStream());
			
			//criamos o output do socket, nesse caso vamos empacotar ela no printstream para que possamos ter tratativas melhores
			PrintStream saidaCliente = new PrintStream(socket.getOutputStream());

			while(entradaCliente.hasNextLine()) {
				String comando = entradaCliente.nextLine();
				System.out.println("comando recebido: " + comando);
				
				//criando as tratativas para os comandos, numa visão de arquitetura de projeto o ideal não seria usar o switch. 
				switch(comando) {
				case "c1" : {
					saidaCliente.println("-Confirmação comando C1-");
					break;
				}
				case "c2" : {
					saidaCliente.println("-Confirmação comando C2-");
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
