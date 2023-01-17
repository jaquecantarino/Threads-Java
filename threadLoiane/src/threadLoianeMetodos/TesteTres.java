package threadLoianeMetodos;

public class TesteTres {

	public static void main(String[] args) {

		MinhaThread threadUm = new MinhaThread("UM", 700);
		MinhaThread threadDois = new MinhaThread("DOIS", 500);
		MinhaThread threadTres = new MinhaThread("TRES", 900);

		Thread t1 = new Thread(threadUm);
		Thread t2 = new Thread(threadDois);
		Thread t3 = new Thread(threadTres);

		t1.start();
//		try {
//			t1.join(200);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		t2.start();
//		try {
//			t2.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		t3.start();
//		try {
//			t3.join(200);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Programa Finalizado");

	}
}
