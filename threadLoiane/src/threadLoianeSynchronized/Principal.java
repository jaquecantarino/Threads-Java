package threadLoianeSynchronized;

public class Principal {

	public static void main(String[] args) {
		
		int[] array = {1, 2, 3, 4, 5};
		minhaThreadSoma t1 = new minhaThreadSoma("1", array);
		minhaThreadSoma t2 = new minhaThreadSoma("2", array);
		minhaThreadSoma t3 = new minhaThreadSoma("3", array);

	}

}
