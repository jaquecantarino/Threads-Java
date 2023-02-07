package threadLoianeMetodosSuspenderParar;

public class Teste {

	public static void main(String[] args) {
		
		MinhaThread t1 = new MinhaThread("t1");
		MinhaThread t2 = new MinhaThread("t2");
		MinhaThread t3 = new MinhaThread("t3");
		
		t1.suspend(); //suspendendo a thred 1 - meu metodo suspend simplesmente muda a flag para true, onde enquanto for verdade ele chama o metodo wait.
		// quanto isso a thred 2 segue
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t3.stop(); //a thread 3 estava rodando normanlmente, mas aqui ela será interrompida, sem terminar a contagem até 10.

		
		t2.suspend(); //aqui a thred 2 também entra em modo de espera, seguindo a mesma logica.
		
		t1.resume(); //o metodo resume basicamente muda o boolean de suspenso para false, saindo o while em que a condição é enquanto estiver suspensa espera = while(estaSuspensa){wait()}
		//logo a thread 1 volta a fazer a contagem
		
		
		try {
			Thread.sleep(350);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t2.resume(); // em seguida a thread 2 sai do suspend seguindo a mesma logica

	}

}
