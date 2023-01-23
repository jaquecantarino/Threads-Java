package cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTarefas {

	public static void main(String[] args) throws Exception {

		Socket socket = new Socket("localhost", 13613);
		System.out.println("Conex�o estabelecida");

		// Criando threads para que nosso cliente possa enviar e receber dados ao mesmo
		// tempo, na vers�o anterior ele recebe dados apenas ap�s parar de envia-los
		// Thead que envia dados
		Thread threadEnviaComando = new Thread(new Runnable() { // aqui estamos usando o atalho para criar uma interface
																// Runnable dentro
																// do nosso c�digo, poderiamos criar uma nova classe.

			@Override
			public void run() {
				try {
					PrintStream saida = new PrintStream(socket.getOutputStream());

					// Vamos adicionar flexibilidade ao comodando.
					Scanner teclado = new Scanner(System.in); // instanciando o scanner do que ser� digitado no teclado
																// pelo usuario
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
					saida.close();
					teclado.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		});

		// Thread que recebe dados
		Thread threadRecebeResposta = new Thread(new Runnable() {

			@Override
			public void run() {
				// agora vamos receber dados ao inves de s� enviar.
				try {
					System.out.println("--Recebendo dados do servidor--");
					Scanner respostaServidor = new Scanner(socket.getInputStream());
					while (respostaServidor.hasNextLine()) { // a regra do while � a mesma do output
						String linha = respostaServidor.nextLine();
						System.out.println(linha);
					}
					respostaServidor.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		});
		
		//iniciando nossas threads
		threadEnviaComando.start();
		threadRecebeResposta.start();
		
		//a thread main vai se juntar a thread que precisamos, nesse caso, ela permanecera ativa at� que a nossa thread esteja ativa.
		threadEnviaComando.join();
		//e somente depois disso vai fechar o socket
		System.out.println("--Fechando sockeet do cliente--");
		socket.close(); 
	}
}
