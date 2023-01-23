package cliente;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTarefasSemThread {

	public static void main(String[] args) throws Exception {

		Socket socket = new Socket("localhost", 13613);
		System.out.println("Conex�o estabelecidade");

		PrintStream saida = new PrintStream(socket.getOutputStream());

		// Vamos adicionar flexibilidade ao comodando.
		Scanner teclado = new Scanner(System.in); // instanciando o scanner do que ser� digitado no teclado pelo usuario
		// Crio um la�o para validar se o meu scanner, no caso apelidado de teclado, tem
		// outra linha ( has next line )
		while (teclado.hasNextLine()) { // enquanto meu teclado tiver outra linha
			String linha = teclado.nextLine();

			// vamos validar se existe de fato um comando digitado
			if (linha.trim().equals("")) { // se for vazio
				break; // vai parar o la�o while
			}

			saida.println(linha); // imprimir o comando que est� sendo digitado
		}
		
		//agora vamos receber dados ao inves de s� enviar.
		System.out.println("--Recebendo dados do servidor--");
		Scanner respostaServidor = new Scanner(socket.getInputStream());
		while(respostaServidor.hasNextLine()) { //a regra do while � a mesma do output
			String linha = respostaServidor.nextLine();
			System.out.println(linha);
		}
		respostaServidor.close();

		saida.close();
		teclado.close();
		socket.close();

	}

}
