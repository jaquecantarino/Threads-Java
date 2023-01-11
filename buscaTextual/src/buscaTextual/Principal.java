package buscaTextual;

public class Principal {

	public static void main(String[] args) {
		
		String nome = "Jef";
		
		//Instanciando nossas threads instanciando a thread e o objeto na mesma linha (outro metodo de fazer, mais enxuto.
		Thread threadAssinaturas = new Thread(new TarefaBuscaTextual("assinaturas1.txt", nome),"threadAssinaturas");
		Thread threadAssinaturas2 = new Thread(new TarefaBuscaTextual("assinaturas2.txt", nome),"threadAssinaturasDois");
		Thread threadAutores = new Thread(new TarefaBuscaTextual("autores.txt", nome),"threadAutores");
		
		//Importante lembrar que a Thread n�o inicia sozinha, precisamos sempre dar star nela
		threadAssinaturas.start();
		threadAssinaturas2.start();
		threadAutores.start();
		
		//INFO: As threads s�o executadas de forma pararela, o que isso quer dizer, que a ordem da exibi��o no meu console pode variar, j� que n�o existe uma ordem de execu��o.
		//Como visualizar isso: Adicione um valor neutro na variavel nome, exemplo: do, de, etc, e execute uma vez, analise a ordem de exibi��o e em seguida execute novamente, e quantas vezes quiser. A probabilidade da ordem de exibi��o do retorno do scan ser diferente nas execu��es � grande.

	}

}
