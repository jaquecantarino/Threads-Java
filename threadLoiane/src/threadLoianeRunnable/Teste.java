package threadLoianeRunnable;

public class Teste {

	public static void main(String[] args) {
		
		MinhaThread threadUm = new MinhaThread("UM", 1200);//Aqui estamos instanciando o objeto MinhaThread
		Thread t1 = new Thread(threadUm); //aqui o objeto está se tornando uma thread
		t1.start();//iniciando a thread
		
		//podemos criar direto no objeto a thread, adicionando a linha Thread(this) no construtor(exemplo está comentado no objeto compartilhado)
		
		MinhaThread threadDois = new MinhaThread("DOIS", 1900);
		Thread t2 = new Thread(threadDois); 
		t2.start();
		
		MinhaThread threadTres = new MinhaThread("TRES", 1500);
		Thread t3 = new Thread(threadTres); 
		t3.start();
	}

}
