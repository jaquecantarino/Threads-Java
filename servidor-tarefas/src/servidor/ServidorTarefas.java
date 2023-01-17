package servidor;

import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTarefas {

	public static void main(String[] args) throws Exception {
		
		System.out.println("---Iniciando Servidor---");
		ServerSocket servidor = new ServerSocket(13613); //aqui estou criado nosso servidor. O ServerSocket, segundo a documenta��o � um ponto de comunica��o entre duas m�quinas, essa classe � responsavel por esperar a conex�o do cliente.
		//a partir desse server eu posso aceitar conex�es
		
		while(true) { //crio esse while para que o meu servidor aceite v�rios clientes
			Socket socket = servidor.accept(); //aqui � onde disponibilizo a conex�o para os clientes. Atribuo ao socket o aceite da nossa instancia servidor
			System.out.println("Aceitando novo cliente na porta: " + socket.getPort());
			
			//deixando varios clientes se conectar ao nosso servidor ao mesmo tempo
			DistribuirTarefas distribuirTarefas = new DistribuirTarefas(socket);
			Thread threadCliente = new Thread(distribuirTarefas);
			threadCliente.start();
			
		}
		
		
	}
	
	/*
	 * O que � um Socket?
	* J� sabemos que vamos utilizar o TCP e que precisamos do IP da m�quina servidora e a porta. Todos esses detalhes do protocolo s�o abstra�dos no mundo Java atrav�s de um socket. Um socket � o ponto-final de um fluxo de comunica��o entre duas aplica��es, atrav�s de uma rede. � exatamente isso que estamos procurando!
	*/

}
