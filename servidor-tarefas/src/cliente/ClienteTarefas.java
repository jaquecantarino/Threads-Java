package cliente;

import java.net.Socket;

public class ClienteTarefas {

	public static void main(String[] args) throws Exception {
		
		Socket socket = new Socket("localhost", 13613); //aqui estou estabelecendo a conexão, pela porta, ao meu servidor
		System.out.println("Conexão estabelecidade");
		
		socket.close(); //encerrando-saindo do cliente

	}

}
