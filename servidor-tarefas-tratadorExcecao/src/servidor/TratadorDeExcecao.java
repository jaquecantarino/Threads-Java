package servidor;

import java.lang.Thread.UncaughtExceptionHandler;

public class TratadorDeExcecao implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		//exibimos que deu erro, o nome e a mensagem.
		System.out.println("Deu exceção na thread " + t.getName() + ", " + e.getMessage());
		
	}

}
