package lista;
public class Lista {

	private String[] elementos = new String[1000]; // criando nossa lista, do javautil, limitada em 100
	private int indice = 0; // indice para saber a posição da lista

	public synchronized void adicionaElementos(String elemento) {
		this.elementos[indice] = elemento;
		this.indice++;

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (this.indice == this.elementos.length) {
			System.out.println("Notificando: lista está cheia!");
			this.notify();
		}
	}

	public int tamanho() {
		return this.elementos.length;
	}

	public String pegaElemento(int posicao) {
		return this.elementos[posicao];
	}
	
    public boolean estaCheia() {
        return this.indice == this.tamanho();
    }
}
