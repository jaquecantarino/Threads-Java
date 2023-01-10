package threads;

public class Principal {

	public static void main(String[] args) throws InterruptedException{
		
		System.out.println("isso é a thread main"); //o proprio main já é uma thread, a maquina virtual cria vários thereads por padrão, está embutido na JVM

		Thread.sleep(30000); //esse metodo estatico faz com que o programa demore um pouco mais para terminar de rodar.
	}
	
	public static void teste(String[] args) {
		//segunda maneira de lançar uma thread, já que ela espera tratamento de exceção.
	    try {
	        Thread.sleep(5000);    
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}

}
