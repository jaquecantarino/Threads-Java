package lista;

//lista é nosso objeto compartilhado
public class Lista {

	private String[] elementos = new String[1000]; //criando nossa lista, do javautil, limitada em 100
    private int indice = 0; //indice para saber a posição da lista

    //metodos para adicionar item
    public void adicionaElementos(String elemento) {
    	synchronized (this) {
            this.elementos[indice] = elemento;
            this.indice++;
		}
    } 

    //metodo para pegar o tamanho da lista
    public int tamanho() {
        return this.elementos.length;
    }

    //metodo para pegar um elemento
    public String pegaElemento(int posicao) {
        return this.elementos[posicao];
    }
}
