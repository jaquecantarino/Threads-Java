package threadLoianeSynchronized;

public class minhaThreadSoma implements Runnable {

	private String nome;
	private int[] nums;
	private static Calculadora calc = new Calculadora(); //todas as instancias dessa classe v�o compartilhar a calculadora.
	
	public minhaThreadSoma(String nome, int[] nums) {
		this.nome = nome;
		this.nums = nums;
		new Thread(this, nome).start();
	}

	@Override
	public void run() {
		System.out.println(this.nome+" iniciada.");
		
		int soma = calc.somaArray(this.nums);
		
		System.out.println("O resultado da soma da thread "+this.nome + " �: "+ soma);
		
		System.out.println(this.nome+" terminada.");
	}
}
