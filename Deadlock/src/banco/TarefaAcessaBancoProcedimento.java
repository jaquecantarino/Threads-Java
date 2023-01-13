package banco;

public class TarefaAcessaBancoProcedimento implements Runnable {

	private PoolDeConexao pool;
	private GerenciadorDeTransacao tx;

	public TarefaAcessaBancoProcedimento(PoolDeConexao pool, GerenciadorDeTransacao tx) {
		this.pool = pool;
		this.tx = tx;
	}

	@Override
	public void run() {
		synchronized (tx) {
			System.out.println("Pegando a chave do POOL");
			pool.getConnection();
			
			synchronized (tx) {
				System.out.println("Gerenciando Transação(TX)");
				tx.begin();
			}
		}
	}
}
