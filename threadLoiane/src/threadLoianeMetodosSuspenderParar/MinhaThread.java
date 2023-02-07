package threadLoianeMetodosSuspenderParar;

public class MinhaThread implements Runnable {

	private String nome;
	private boolean estaSuspensa; //criando a flag
	private boolean foiTerminada; //criando a flag para terminar a thread

	public MinhaThread(String nome) {
		this.nome = nome;
		this.estaSuspensa = false; //sempre vai começar não suspensa
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
						break; //vai sair do for (linha 20) e vai terminar a execução da thread
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Thread: " + this.nome + " terminada!");
	}
	
	void suspend() { //criando o suspend na mão.
		this.estaSuspensa = true;
	}
	
	synchronized void resume() { //criando o retormo na mão.
		this.estaSuspensa = false;
		notify(); //o metodo notify, que notifica todos, só funciona em blocos sincronizados, que são com quem ele vai conversar
	}
	
	synchronized void stop() { //criando o metodo stop na mão
		this.foiTerminada = true;
		notify();
		//vamos usar o stop quando queremos parar a execução da thread completamente.
	}

}
