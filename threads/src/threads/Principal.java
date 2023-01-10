package threads;

public class Principal {

	public static void main(String[] args) throws InterruptedException{
		
		System.out.println("isso � a thread main"); //o proprio main j� � uma thread, a maquina virtual cria v�rios thereads por padr�o, est� embutido na JVM

		Thread.sleep(30000); //esse metodo estatico faz com que o programa demore um pouco mais para terminar de rodar.
	}
	
	public static void teste(String[] args) {
		//segunda maneira de lan�ar uma thread, j� que ela espera tratamento de exce��o.
	    try {
	        Thread.sleep(5000);    
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}

}
