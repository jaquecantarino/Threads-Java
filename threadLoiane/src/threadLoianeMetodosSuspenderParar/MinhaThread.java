package threadLoianeMetodosSuspenderParar;

public class MinhaThread implements Runnable {

	private String nome;
	private boolean estaSuspensa; //criando a flag
	private boolean foiTerminada; //criando a flag para terminar a thread

	public MinhaThread(String nome) {
		this.nome = nome;
		this.estaSuspensa = false; //sempre vai come�ar n�o suspensa
		new Thread(this, nome).start();
	}

	@Override
	public void run() {
		System.out.println("Executando: " + this.nome);

		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("Thread " + nome + ", " + i);
				Thread.sleep(300);
				synchronized (this) { //iniciando um bloco sincronizado, e como vamos usar a propria thread, vamos usar a classe toda, por isso o (this)
					while(estaSuspensa) {
						wait(); // wait vai suspender o stop.
					}
					if(this.foiTerminada) { //se foi terminada,
						break; //vai sair do for (linha 20) e vai terminar a execu��o da thread
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Thread: " + this.nome + " terminada!");
	}
	
	void suspend() { //criando o suspend na m�o.
		this.estaSuspensa = true;
	}
	
	synchronized void resume() { //criando o retormo na m�o.
		this.estaSuspensa = false;
		notify(); //o metodo notify, que notifica todos, s� funciona em blocos sincronizados, que s�o com quem ele vai conversar
	}
	
	synchronized void stop() { //criando o metodo stop na m�o
		this.foiTerminada = true;
		notify();
		//vamos usar o stop quando queremos parar a execu��o da thread completamente.
	}

}
