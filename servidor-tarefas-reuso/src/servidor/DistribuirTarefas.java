package servidor;

import java.net.Socket;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintStream;

import javax.management.RuntimeErrorException;

public class DistribuirTarefas implements Runnable {

	private Socket socket;

	public DistribuirTarefas(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			System.out.println("Distribuindo tarefas para: " + socket);

			Scanner entradaCliente = new Scanner(socket.getInputStream());

			while(entradaCliente.hasNextLine()) {
				String comando = entradaCliente.nextLine();
				System.out.println(comando);
			}		
			entradaCliente.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 

	}

}
