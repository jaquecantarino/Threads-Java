package exercicioSemaforo;

//Proposta: Imagine que se pretendia suportar em Java um mecanismo de sem�foros. 
// Como � que se poderia definir uma classe sem�foro que fosse capaz de suportar a funcionalidade dos
//sem�foros?
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
			System.out.println(nome + " est�: Amarelo ");
		} else if (this.luzAmarela) {
			this.luzVermelha=true;
			this.luzAmarela=false;
			String nome = Thread.currentThread().getName();
			System.out.println(nome + " est�: Vermelho ");
		}else if(this.luzVermelha) {
			this.luzVerde=true;
			this.luzVermelha=false;
			String nome = Thread.currentThread().getName();
			System.out.println(nome + " est�: Verde ");
		}
	}
}
