package exercicioSemaforo;

//Proposta: Imagine que se pretendia suportar em Java um mecanismo de semáforos. 
// Como é que se poderia definir uma classe semáforo que fosse capaz de suportar a funcionalidade dos
//semáforos?
//O farol abre a cada 60 segundos.

public class Semaforo {
	
	private boolean luzVerde = true;
	private boolean luzAmarela = false;
	private boolean luzVermelha = false;
	
	public void mudaSemaforo() {
		if(this.luzVerde) {
			this.luzAmarela=true;
			this.luzVerde=false;
			String nome = Thread.currentThread().getName();
			System.out.println(nome + " está: Amarelo ");
		} else if (this.luzAmarela) {
			this.luzVermelha=true;
			this.luzAmarela=false;
			String nome = Thread.currentThread().getName();
			System.out.println(nome + " está: Vermelho ");
		}else if(this.luzVermelha) {
			this.luzVerde=true;
			this.luzVermelha=false;
			String nome = Thread.currentThread().getName();
			System.out.println(nome + " está: Verde ");
		}
	}
}
