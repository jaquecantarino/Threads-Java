public class Principal {

	public static void main(String[] args) {

		Thread threadUm = new Thread(new ImprimeNumero(), "threadUm"); //criando a primeira thread
		Thread threadDois = new Thread(new ImprimeNumero(), "threadDois"); //criando a segunda thread

		//iniciando
		threadUm.start();
		threadDois.start();
		
		//Objetivo: Analisar a ordem de execu��o que pode ser feita das threads, n�o existe uma regra
	}
}
