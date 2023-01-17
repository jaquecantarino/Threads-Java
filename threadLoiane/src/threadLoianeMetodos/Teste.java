package threadLoianeMetodos;

public class Teste {

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

		while (t1.isAlive() || t2.isAlive() || t3.isAlive()) {
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Programa Finalizado");

	}
}
