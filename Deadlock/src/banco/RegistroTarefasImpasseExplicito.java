package banco;

public class RegistroTarefasImpasseExplicito {

	// Classe criada para armazenar as duas tarefas na primeira versão
	/*
	 * onde temos o impasse de cada tarefa pegar uma chave impedindo que a execução
	 * da outra seja continuada o que chamamos de deadlock.
	 */

	// O QUE É:
	// Uma thread segura um recurso e aguarda por outro.

	// COMO RESOLVER?
	// Respeitando o fluxo de execução, das tarefas abaixo as execuções estavam
	// invertidas, ocasionando o impasse
	// ao rejustar, adaptando o fluxo para que ele sigam o mesmo padrão, então:
	// mudando no TarefaAcessaBancoProcedimento a ordem de ações, eles não colidem
	// mais.

	// O que acontece em um software quando ocorre um deadlock?
	// Somente as threads envolvidas no deadlock ficam paradas.

	/*
	 * • Podemos usar um bloco synchronized dentro do outro. • Ao obter os recursos,
	 * pode acontecer um impasse (interbloqueio). • O impasse também é chamado
	 * deadlock. •Podemos evitar o impasse obtendo as chaves dos objetos na mesma
	 * ordem, em todos os threads.
	 */

//	public class TarefaAcessarBanco implements Runnable {
//
//	    private PoolDeConexao pool;
//	    private GerenciadorDeTransacao tx;
//
//		public TarefaAcessarBanco(PoolDeConexao pool, GerenciadorDeTransacao tx) {
//	        this.pool = pool;
//	        this.tx = tx;
//	    }
//
//	    @Override
//	    public void run(){
//	    	synchronized (pool) {
//				System.out.println("Pegando a chave do POOL");
//				pool.getConnection();
//				
//				synchronized (tx) {
//					System.out.println("Gerenciando Transação(TX)");
//					tx.begin();
//				}
//			}
//
//	    }
//
//	}
//	
//	public class TarefaAcessaBancoProcedimento implements Runnable {
//
//		private PoolDeConexao pool;
//		private GerenciadorDeTransacao tx;
//
//		public TarefaAcessaBancoProcedimento(PoolDeConexao pool, GerenciadorDeTransacao tx) {
//			this.pool = pool;
//			this.tx = tx;
//		}
//
//		@Override
//		public void run() {
//			synchronized (tx) {
//
//				System.out.println("Peguei a chave da tx");
//				tx.begin();
//
//				synchronized (pool) {
//
//					System.out.println("Peguei a chave do pool");
//					pool.getConnection();
//				}
//			}
//		}
//	}

}
