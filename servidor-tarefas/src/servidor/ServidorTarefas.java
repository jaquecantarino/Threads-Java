package servidor;

import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTarefas {

	public static void main(String[] args) throws Exception {
		
		System.out.println("---Iniciando Servidor---");
		ServerSocket servidor = new ServerSocket(13613); //aqui estou criado nosso servidor. O ServerSocket, segundo a documentação é um ponto de comunicação entre duas máquinas, essa classe é responsavel por esperar a conexão do cliente.
		//a partir desse server eu posso aceitar conexões
		
		while(true) { //crio esse while para que o meu servidor aceite vários clientes
			Socket socket = servidor.accept(); //aqui é onde disponibilizo a conexão para os clientes. Atribuo ao socket o aceite da nossa instancia servidor
			System.out.println("Aceitando novo cliente na porta: " + socket.getPort());
			
			//deixando varios clientes se conectar ao nosso servidor ao mesmo tempo
			DistribuirTarefas distribuirTarefas = new DistribuirTarefas(socket);
			Thread threadCliente = new Thread(distribuirTarefas);
			threadCliente.start();
			
		}
		
		
	}
	
	/*
	 * O que é um Socket?
	* Já sabemos que vamos utilizar o TCP e que precisamos do IP da máquina servidora e a porta. Todos esses detalhes do protocolo são abstraídos no mundo Java através de um socket. Um socket é o ponto-final de um fluxo de comunicação entre duas aplicações, através de uma rede. É exatamente isso que estamos procurando!
	*/

}
