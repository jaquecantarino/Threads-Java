package banheiro;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banheiro {
	
	//Nesses exemplos eu vou usar o synchronyzed em um bloco e o ReentrantLock em outro para ter exemplos visuais das duas alternativas
	
//	public void fazNumeroUm() {
//		
//		//Aqui criamos essa linha para que ele possa retornar o thread atual, ou seja, nessa linha ele vai exibir o nome criado l� na principal (ultimo parametro na instancia de thread) que identifica o thread
//		String nome = Thread.currentThread().getName();
//		
//		//Essa a��o vai ocorrer sem regra, em qualquer ordem
//		System.out.println(nome + " batendo na porta!!!");
//		
//		//O synchronized faz com que as a��es da thread n�o sejam executadas sem ordem, ou seja, tudo que est� dentro desse trecho s� � executado se outra a��o da thread n�o tiver sendo executada
//		//modificador que deve ser colocado em um m�todo para que n�o possa ser executado por duas Threads ao mesmo tempo
//		synchronized (this) { //essa chave(this) tamb�m � chamado de mutex
//			System.out.println(nome + " Entrando no banheiro");
//			System.out.println(nome + " Fazendo coisa rapida");
//			try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.println(nome + " Dando Descarga");
//			System.out.println(nome + " Lavando as m�os");
//			System.out.println(nome + " Saindo do Banheiro");			
//		}
//	}
//	
//	public void fazNumeroDois() {
//		
//		String nome = Thread.currentThread().getName();
//		
//		System.out.println(nome + " batendo na porta!!!");
//		
//		synchronized (this) {
//			System.out.println(nome + " Entrando no banheiro");
//			System.out.println(nome + " Fazendo coisa demorada");
//			try {
//				Thread.sleep(10000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.println(nome + " Dando Descarga");
//			System.out.println(nome + " Lavando as m�os");
//			System.out.println(nome + " Saindo do Banheiro");			
//		}
//	}
	
    private Lock lock = new ReentrantLock();
	
	public void fazNumeroUm() {
		
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " batendo na porta!!!");
		
		lock.lock(); //Explicitamente mostramos no c�digo quando abre e quando fecha a porta da thread
		
		//todo o restante funciona igual
		
			System.out.println(nome + " Entrando no banheiro");
			System.out.println(nome + " Fazendo coisa rapida");
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(nome + " Dando Descarga");
			System.out.println(nome + " Lavando as m�os");
			System.out.println(nome + " Saindo do Banheiro");
			
		lock.unlock(); // fechando a porta
	}
    
	public void fazNumeroDois() {
		
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " batendo na porta!!!");
		
		lock.lock();
		
			System.out.println(nome + " Entrando no banheiro");
			System.out.println(nome + " Fazendo coisa demorada");
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(nome + " Dando Descarga");
			System.out.println(nome + " Lavando as m�os");
			System.out.println(nome + " Saindo do Banheiro");
		lock.unlock();
	}

}
