package listaPadraoJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Principal {

	public static void main(String[] args) throws InterruptedException {
		
		//List<String> lista = new ArrayList<>(); //instanciando uma lista padr�o java, do javautil
		//List<String> lista = Collections.synchronizedList(new ArrayList<String>());
		List<String> lista = new Vector<String>();
		
		//criando 10 instancias do objeto lista
		for (int i=0; i<10; i++) {
			new Thread(new TarefaAdicionaElemento(lista, i)).start();
		}
		
		Thread.sleep(2000);
		
		for(int i=0; i<lista.size();i++){
			System.out.println(lista.get(i));
		}
		
		

	}
/*
 * No primeiro exemplo (arquivo:lista) usamos um objeto compartilhado para exemplificar as a��es de uma lista
 * padr�o java, o que normalmente n�o acontece, usamos as listas para nossas aplica��es do dia a dia, por isso essa adapta��o;
 * 
 * Segundo a documenta��o do ArrayList n�o � seguro trabalhar com synchronized manipulando Listas, como podemos resolver: usamos o Collection.synchronizedList
 * ou podemos usar o Vector, que nesse caso � synchronized
 */
}
