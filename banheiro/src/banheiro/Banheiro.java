package banheiro;

public class Banheiro {
	
	public void fazNumeroUm() {
		
		//Aqui criamos essa linha para que ele possa retornar o thread atual, ou seja, nessa linha ele vai exibir o nome criado lá na principal (ultimo parametro na instancia de thread) que identifica o thread
		String nome = Thread.currentThread().getName();
		
		//Essa ação vai ocorrer sem regra, em qualquer ordem
		System.out.println(nome + " batendo na porta!!!");
		
		//O synchronized faz com que as ações da thread não sejam executadas sem ordem, ou seja, tudo que está dentro desse trecho só é executado se outra ação da thread não tiver sendo executada
		synchronized (this) {
			System.out.println(nome + " Entrando no banheiro");
			System.out.println(nome + " Fazendo coisa rapida");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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
			System.out.println(nome + " Fazendo coisa demorada");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(nome + " Dando Descarga");
			System.out.println(nome + " Lavando as mãos");
			System.out.println(nome + " Saindo do Banheiro");
		}
	}

}
