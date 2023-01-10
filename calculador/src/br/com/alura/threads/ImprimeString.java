package br.com.alura.threads;

public class ImprimeString implements Runnable{
	
	private String texto;

	public ImprimeString(String texto) {
		super();
		this.texto = texto;
	}

	@Override
	public void run() {
		System.out.println(texto);
		
	}

}
