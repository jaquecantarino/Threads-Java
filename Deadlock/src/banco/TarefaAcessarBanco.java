package banco;

public class TarefaAcessarBanco implements Runnable {

    private PoolDeConexao pool;
    private GerenciadorDeTransacao tx;

	public TarefaAcessarBanco(PoolDeConexao pool, GerenciadorDeTransacao tx) {
        this.pool = pool;
        this.tx = tx;
    }

    @Override
    public void run(){
    	synchronized (pool) {
			System.out.println("Pegando a chave do POOL");
			pool.getConnection();
			
			synchronized (tx) {
				System.out.println("Gerenciando Transação(TX)");
				tx.begin();
			}
		}

    }

}
