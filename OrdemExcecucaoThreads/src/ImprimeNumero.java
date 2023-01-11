public class ImprimeNumero implements Runnable{

	@Override
	public void run() {
		
		int numero = 0; //inicia contador
		
		while(numero <= 1000) { //enquanto o meu numero for menor ou igual a 1000 vai executar os comandos abaixo
			System.out.println(numero); //imprime o numero na tela
			
			//esse espaço cria e imprime o id da thread, usamos para ver a ordem de execução paralela que é criada
			Thread threadAtual = Thread.currentThread();
			long id = threadAtual.getId();
			System.out.println("Id da thread: " + id);
			
			numero++; //incrementa o numero a cada volta
		}	
	}
}
