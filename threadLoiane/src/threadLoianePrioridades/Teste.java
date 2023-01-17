package threadLoianePrioridades;

import threadLoianeMetodos.MinhaThread;

public class Teste {

	public static void main(String[] args) {
		
			MinhaThread threadUm = new MinhaThread("UM", 500);
			MinhaThread threadDois = new MinhaThread("DOIS", 500);
			MinhaThread threadTres = new MinhaThread("TRES", 500);

			Thread t1 = new Thread(threadUm);
			Thread t2 = new Thread(threadDois);
			Thread t3 = new Thread(threadTres);
			
			//adicionando prioridade na execução das nossas threads.
			t1.setPriority(5); //poderia ser também: t1.setPriority(Thread.NORM_PRIORITY);
			t2.setPriority(10); //poderia ser também: t1.setPriority(Thread.MAX_PRIORITY);
			t3.setPriority(1); //poderia ser também: t1.setPriority(Thread.MIN_PRIORITY);
			//é importante lembrar que apesar de na maioria das vezes a prioridade ser respeita
			//isso não é uma garantia.

			t1.start();
			t2.start();
			t3.start();

		}
}
