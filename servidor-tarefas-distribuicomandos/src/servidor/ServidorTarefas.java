package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServidorTarefas {

	private ServerSocket servidor;
	private ExecutorService threadPool;
	private AtomicBoolean estaRodando;

	public ServidorTarefas() throws IOException {
		System.out.println("---Iniciando Servidor---");
		this.servidor = new ServerSocket(13613);
		this.threadPool = Executors.newFixedThreadPool(4); //newCachedThreadPool();
		this.estaRodando = new AtomicBoolean(true);
	}

	public void parar() throws IOException {
		this.estaRodando.set(false);
		this.servidor.close();
		this.threadPool.shutdown();
		System.out.println("---Parando Servidor---");
	}

	public void rodar() throws IOException {
		while (this.estaRodando.get()) {
			try {
				Socket socket = this.servidor.accept();
				System.out.println("Aceitando novo cliente na porta: " + socket.getPort());

				DistribuirTarefas distribuirTarefas = new DistribuirTarefas(threadPool, socket, this);
				this.threadPool.execute(distribuirTarefas);
			} catch (SocketException e) {
				System.out.println("SocketException, está rodando? " + this.estaRodando);
			}
		}
	}

	public static void main(String[] args) throws IOException {

		ServidorTarefas servidor = new ServidorTarefas();
		servidor.rodar();
		servidor.parar();
	}
}
