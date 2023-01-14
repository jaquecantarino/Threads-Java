package exercicioSemaforo;

public class Cruzamento {

	public static void main(String[] args) {
		
		Semaforo semaforo = new Semaforo();
		
		Thread semaforoUm = new Thread(new TarefaUm(semaforo),"SemaforoUm");
		Thread semaforoDois = new Thread(new TarefaUm(semaforo),"SemaforoDois");
		
		semaforoUm.start();
		semaforoDois.start();
	}

}
