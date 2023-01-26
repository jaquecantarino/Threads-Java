package threadLoianeMetodosNotifyAllWait;

public class TicTac {

	boolean tic; // essa variavel é quem vai definir a hora que o tic sera impresso

	/***incia tic***/
	synchronized void tic(boolean estaExecutando) { //nosso metodo sincronizado vai receber um boolean que diz se o tic está true ou não
		if (!estaExecutando) { //se estiver false (!) então
			tic = true; // vai transformar em true
			notify(); // e notificar as outras threads
			return;
		}
		//se o tic já estiver true, então:
		System.out.print("TIC "); // vai imprir a palavra "TIC" no console

		tic = true; // mudar tic pra true

		notify(); // notificar os outros metodos

		try {
			while (tic) { // enquanto ele tive tic (true) então
				wait(); //vai esperar (*o wait() precisa de try/catch*)
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/***encerra tic***/
	
	/***incia tac***/
	synchronized void tac(boolean estaExecutando) { //nosso metodo sincronizado vai receber um boolean que diz se o tic está true ou não
		if (!estaExecutando) { //se estiver false (!) então
			tic = false; // vai transformar em false
			notify(); // e notificar as outras threads
			return;
		}
		//se o tic já estiver false, então:
		System.out.print("TAC "); // vai imprir a palavra "TAC" no console

		tic = false; // mudar tic pra false

		notify(); // notificar os outros metodos

		try {
			while (!tic) { // enquanto ele não tiver tic (false) então
				wait(); //vai esperar (*o wait() precisa de try/catch*)
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/***encerra tac***/
}
