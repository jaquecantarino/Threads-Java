package banheiro;

public class Principal {

	public static void main(String[] args) {
		
		Banheiro banheiro = new Banheiro();
		
		Thread convidadoUm = new Thread(new TarefaUm(banheiro),"ConvidadoUm");
		Thread convidadoDois = new Thread(new TarefaDois(banheiro),"ConvidadoDois");
		Thread limpeza = new Thread(new TarefaLimpeza(banheiro), "Limpeza");
		limpeza.setDaemon(true); //ele transforma nossa thread de limpeza em uma thread que depende de outras threads
		/*
		 * Isso �: quando as threads convidadoUm e convidadoDois morrerem a thread limpeza vai morrer tamb�m
		 * (S�o provedores de servi�os para outras threads.)
		 */


		convidadoUm.start();
		convidadoDois.start();
		limpeza.start();
	}
	/*
	 * � ao chamar object.wait() a thread fica no estado de espera
� estado de espera significa WAITING no mundo de threads
� uma thread esperando pode ser notificada pelo m�todo object.notifyAll()
� existem daemon threads para executar tarefas ou servi�os secund�rios
� daemons ser�o automaticamente desligados quando todas as outras threads terminarem
	 */
}
