package threadLoiane;

public class MinhaThread extends Thread {

	private String nome;
	private int tempo;

	public MinhaThread(String nome, int tempo) {
		this.nome = nome;
		this.tempo = tempo;
		start(); // podemos colocar o star dentro do construtor do objeto, assim,
					// logo que ele é instanciado na aplicação não precisamos fazer manualmente o
					// star com thread.start();
	}

	public void run() {
		// System.out.println("Executando a Thread");

		try {
			for (int i = 0; i < 6; i++) {
				System.out.println(nome + " contador: " + i);
				Thread.sleep(tempo);
			}
		} catch (InterruptedException e) { // essa exeção indica que a Thread foi interrompida
			e.printStackTrace();
		}
		
		System.out.println(nome+" Termino a execução!!");
	}
}
