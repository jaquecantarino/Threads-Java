package lista;

public class Principal {

	public static void main(String[] args) throws InterruptedException {
		
		Lista lista = new Lista(); //instanciando meu objeto compartilhado
		
		//criando 10 instancias do objeto lista
		for (int i=0; i<10; i++) {
			new Thread(new TarefaAdicionaElemento(lista, i)).start();
		}
		
		new Thread(new TarefaImprimir(lista)).start();
		
	}
}
/*
 * •wait() e notify() sempre devem ser chamados dentro de um bloco synchronized;
 * • Temos que ter cuidado para não mandar um thread esperar quando não há necessidade;
*/
