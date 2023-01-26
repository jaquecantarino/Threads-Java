package threadLoianeMetodosNotifyAllWait;

public class TicTac {

	boolean tic; // essa variavel � quem vai definir a hora que o tic sera impresso

	/***incia tic***/
	synchronized void tic(boolean estaExecutando) { //nosso metodo sincronizado vai receber um boolean que diz se o tic est� true ou n�o
		if (!estaExecutando) { //se estiver false (!) ent�o
			tic = true; // vai transformar em true
			notify(); // e notificar as outras threads
			return;
		}
		//se o tic j� estiver true, ent�o:
		System.out.print("TIC "); // vai imprir a palavra "TIC" no console

		tic = true; // mudar tic pra true

		notify(); // notificar os outros metodos

		try {
			while (tic) { // enquanto ele tive tic (true) ent�o
				wait(); //vai esperar (*o wait() precisa de try/catch*)
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/***encerra tic***/
	
	/***incia tac***/
	synchronized void tac(boolean estaExecutando) { //nosso metodo sincronizado vai receber um boolean que diz se o tic est� true ou n�o
		if (!estaExecutando) { //se estiver false (!) ent�o
			tic = false; // vai transformar em false
			notify(); // e notificar as outras threads
			return;
		}
		//se o tic j� estiver false, ent�o:
		System.out.print("TAC "); // vai imprir a palavra "TAC" no console

		tic = false; // mudar tic pra false

		notify(); // notificar os outros metodos

		try {
			while (!tic) { // enquanto ele n�o tiver tic (false) ent�o
				wait(); //vai esperar (*o wait() precisa de try/catch*)
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/***encerra tac***/
}
