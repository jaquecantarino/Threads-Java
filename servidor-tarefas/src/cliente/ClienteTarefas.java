package cliente;

import java.net.Socket;

public class ClienteTarefas {

	public static void main(String[] args) throws Exception {
		
		Socket socket = new Socket("localhost", 13613); //aqui estou estabelecendo a conex�o, pela porta, ao meu servidor
		System.out.println("Conex�o estabelecidade");
		
		socket.close(); //encerrando-saindo do cliente

	}

}
