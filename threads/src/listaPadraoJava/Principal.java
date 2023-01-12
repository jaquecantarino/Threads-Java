package listaPadraoJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Principal {

	public static void main(String[] args) throws InterruptedException {
		
		//List<String> lista = new ArrayList<>(); //instanciando uma lista padrão java, do javautil
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
 * No primeiro exemplo (arquivo:lista) usamos um objeto compartilhado para exemplificar as ações de uma lista
 * padrão java, o que normalmente não acontece, usamos as listas para nossas aplicações do dia a dia, por isso essa adaptação;
 * 
 * Segundo a documentação do ArrayList não é seguro trabalhar com synchronized manipulando Listas, como podemos resolver: usamos o Collection.synchronizedList
 * ou podemos usar o Vector, que nesse caso é synchronized
 */
}
