package lista;

public class Principal {

	public static void main(String[] args) throws InterruptedException {
		
		Lista lista = new Lista(); //instanciando meu objeto compartilhado
		
		//criando 10 instancias do objeto lista
		for (int i=0; i<10; i++) {
			new Thread(new TarefaAdicionaElemento(lista, i)).start();
		}
		
		Thread.sleep(2000);
		
		for(int i=0; i<lista.tamanho();i++){
			System.out.println(lista.pegaElemento(i));
		}
		
		

	}
	
	//resumindo:
	/*
	 * No meu objeto compartilhado Lista, eu tenho uma lista de 100 elementos
	 * Na minha classe principal eu tenho um for que cria 10 instancias de threads
	 * E na minha classe Runnable eu tenho um for que adiciona 10 elementos em cada thread
	 * 10*10=100
	 */

}
