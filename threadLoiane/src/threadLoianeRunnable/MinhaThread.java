package threadLoianeRunnable;

public class MinhaThread implements Runnable {

	private String nome;
	private int tempo;

	public MinhaThread(String nome, int tempo) {
		this.nome = nome;
		this.tempo = tempo;
		// o star() aqui porque ele não está disponivel na interface runnable
		//Thread t = new Thread(this); nessa linha eu já faço com que meu objeto seja instanciado como thread na minha aplição sem precisar separar essa instancia, deixando aqui como exemplo, mas continuarei usando a forma mais verbosa por enquanto
		//se eu usar a instancia da thread no construtor posso adicionar o start() no final dele
	}

	@Override
	public void run() {

		try {
			for (int i = 0; i < 6; i++) {
				System.out.println(nome + " contador:" + i);
				Thread.sleep(tempo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(nome + " Termino a execução!!");

	}

}
