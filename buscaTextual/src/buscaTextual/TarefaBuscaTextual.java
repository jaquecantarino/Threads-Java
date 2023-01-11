package buscaTextual;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TarefaBuscaTextual implements Runnable {

	private String nomeArquivo;
	private String nome;
	
	//Crio meu construtor
	public TarefaBuscaTextual(String nomeArquivo, String nome) {
		this.nomeArquivo = nomeArquivo;
		this.nome= nome;
	}

	//Crio meu run = o run � onde a a��o da thread fica armazenada
	@Override
	public void run() {
		//Usamos o try...catch porque instanciamos o File, e ao usa-lo precisamos tratar uma exce��o
		try {
			Scanner scanner = new Scanner(new File(nomeArquivo)); //Instanciamos o scanner para que ele varra nosso arquivo de assinaturas
			
			int numeroLinha = 1;
			
			while(scanner.hasNextLine()) { //A condi��o do nosso while �, ele vai rodar enquanto existir uma pr�xima linha
				String linha = scanner.nextLine();
				
				if(linha.toLowerCase().contains(nome.toLowerCase())) { //Se na linha conter o conteudo da variavel nome ent�o
					//toLowerCase() = transforma todas as letrass em minusculo, tornando a busca mais abrangente
					System.out.println(nomeArquivo + " - " + numeroLinha + " - " +linha); //vai imprimir na tela
				}
				numeroLinha++; //e incrementar
			}
			
			scanner.close(); //encerramento do nosso scanner
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e); //Essa linha exclui a necessidade de um tratamento explicito do nosso try...catch (tratamento do tratamento)
		}

		
	}
}
