package banheiro;

public class Banheiro {

	private boolean eSujo = true;

	public void fazNumeroUm() {

		String nome = Thread.currentThread().getName();

		System.out.println(nome + " batendo na porta!!!");

		synchronized (this) {
			System.out.println(nome + " Entrando no banheiro");

			while(this.eSujo) { // a mudança de if para while aconteceu para que rode novamente a condição
									// quando essa thread for notificada pelo limpar e assim só rode se eSujo for
									// false.
				esperaLaFora(nome);
			}

			System.out.println(nome + " Fazendo coisa rapida");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			this.eSujo = true; // Após o uso o convidado deixa o banheiro sujo novamente

			System.out.println(nome + " Dando Descarga");
			System.out.println(nome + " Lavando as mãos");
			System.out.println(nome + " Saindo do Banheiro");
		}
	}

	public void fazNumeroDois() {

		String nome = Thread.currentThread().getName();

		System.out.println(nome + " batendo na porta!!!");

		synchronized (this) {
			System.out.println(nome + " Entrando no banheiro");
			while(this.eSujo) {
				esperaLaFora(nome);
			}
			System.out.println(nome + " Fazendo coisa demorada");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			this.eSujo = true;

			System.out.println(nome + " Dando Descarga");
			System.out.println(nome + " Lavando as mãos");
			System.out.println(nome + " Saindo do Banheiro");
		}
	}

	public void limpar() {

		String nome = Thread.currentThread().getName();

		System.out.println(nome + " batendo na porta!!!");

		synchronized (this) {
			System.out.println(nome + " Entrando no banheiro");

			if (!this.eSujo) {
				System.out.println(nome + ": Banheiro não está sujo, vou sair");
				return;
			}

			System.out.println(nome + " Limpando o banheiro!");
			this.eSujo = false;

			try {
				Thread.sleep(12000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			this.notifyAll();
			System.out.println(nome + " Saindo do Banheiro");
		}

	}

	private void esperaLaFora(String nome) {
		System.out.println(nome + ", eca, banheiro está sujo");
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
