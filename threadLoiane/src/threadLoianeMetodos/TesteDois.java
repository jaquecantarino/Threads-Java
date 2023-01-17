package threadLoianeMetodos;

public class TesteDois {

	public static void main(String[] args) {

		MinhaThread threadUm = new MinhaThread("UM", 500);
		MinhaThread threadDois = new MinhaThread("DOIS", 500);
		MinhaThread threadTres = new MinhaThread("TRES", 500);

		Thread t1 = new Thread(threadUm);
		Thread t2 = new Thread(threadDois);
		Thread t3 = new Thread(threadTres);

		t1.start();
		t2.start();
		t3.start();

		for (int i = 0; i < 15; i++) {
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Programa Finalizado");

	}
}
