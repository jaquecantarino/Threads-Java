package experimento;

import java.util.concurrent.atomic.AtomicBoolean;

public class ServidorTeste {

	//exemplificando o problema.
		private volatile boolean estaRodando = false;
		//private AtomicBoolean estaRodando;

		public static void main(String[] args) throws InterruptedException {
			ServidorTeste servidor = new ServidorTeste();
			servidor.rodar();
			servidor.alterandoAtributo();
		}

		private void rodar() {
			new Thread(new Runnable() {

				public void run() {
					System.out.println("Servidor começando, estaRodando = " + estaRodando);

					while (!estaRodando) {
					}

					System.out.println("Servidor rodando, estaRodando = " + estaRodando);

					while (estaRodando) {
					}

					System.out.println("Servidor terminando, estaRodando = " + estaRodando);
				}
			}).start();
		}

		private void alterandoAtributo() throws InterruptedException {
			Thread.sleep(5000);
			System.out.println("Main alterando estaRodando = true");
			estaRodando = true;

			Thread.sleep(5000);
			System.out.println("Main alterando estaRodando = false");
			estaRodando = false;
		}
}
