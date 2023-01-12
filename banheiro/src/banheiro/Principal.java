package banheiro;

public class Principal {

	public static void main(String[] args) {
		
		Banheiro banheiro = new Banheiro();
		
		Thread convidadoUm = new Thread(new TarefaUm(banheiro),"ConvidadoUm");
		Thread convidadoDois = new Thread(new TarefaDois(banheiro),"ConvidadoDois");
		Thread convidadoTres = new Thread(new TarefaUm(banheiro),"ConvidadoTres");

		
		convidadoUm.start();
		convidadoDois.start();
		convidadoTres.start();
	}
	
	//operação atômica= operações que a execução não pode ser interrompida na metade.
//ReentrantLock = alternativa para o synchronized que faz o bloqueio de forma explícita no código
}
