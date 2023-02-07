package threadLoianeDeadlock;

public class Deadlock {

	public static void main(String[] args) {
		
		final String recurso1 = "Recurso #1";
		final String recurso2 = "Recurso #2";
		
		//CAUSANDO O DEADLOCK
		//classe aninhada-anonima
		Thread t1 = new Thread() {
			public void run() {
				synchronized (recurso1) {
					System.out.println("Thread #1: Bloqueou o recuso 1");
					
					try {
						Thread.sleep(150);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					System.out.println("Thread #1: tentando acesso ao recurso 2");
					
					synchronized (recurso2) {
						System.out.println("Thread #1: bloqueou o recuso 2");
					}
				}
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				synchronized (recurso2) {
					System.out.println("Thread #2: Bloqueou o recuso 2");
					
					try {
						Thread.sleep(150);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					System.out.println("Thread #2: tentando acesso ao recurso 1");
					
					synchronized (recurso1) {
						System.out.println("Thread #2: bloqueou o recuso 1");
					}
				}
			}
		};
		
		t1.start();
		t2.start();
				

	}

}
