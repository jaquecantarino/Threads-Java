package threadLoianeMetodosNotifyAllWait;

public class Principal {

	public static void main(String[] args) {

		TicTac tt = new TicTac();
		ThreadTicTac tic = new ThreadTicTac("Tic", tt);
		ThreadTicTac tac = new ThreadTicTac("Tac", tt);

		try {
			tic.t.join();
			tac.t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
