package servidor;

import java.lang.Thread.UncaughtExceptionHandler;

public class TratadorDeExcecao implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		System.out.println("Exce��o na thread " + thread.getName() + ": " + ex.getMessage());
	}
}