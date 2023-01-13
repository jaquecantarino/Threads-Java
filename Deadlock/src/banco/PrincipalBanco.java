package banco;

//esse projeto chama banco porque vamos usar o banco de dados.
public class PrincipalBanco {

	public static void main(String[] args) {

		GerenciadorDeTransacao tx = new GerenciadorDeTransacao();
		PoolDeConexao pool = new PoolDeConexao();
		
		new Thread(new TarefaAcessarBanco(pool, tx),"DevUm").start();
		new Thread(new TarefaAcessaBancoProcedimento(pool, tx),"DevDois").start();

		
	}

}
