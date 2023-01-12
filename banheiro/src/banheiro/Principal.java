package banheiro;

public class Principal {

	public static void main(String[] args) {
		
		Banheiro banheiro = new Banheiro();
		
		Thread convidadoUm = new Thread(new TarefaUm(banheiro),"ConvidadoUm");
		Thread convidadoDois = new Thread(new TarefaDois(banheiro),"ConvidadoDois");
		
		convidadoUm.start();
		convidadoDois.start();
	}

}
