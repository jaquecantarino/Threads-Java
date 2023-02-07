### Threads-Java

##### Alura: Threads em Java 1: programação paralela (16h)
        Link: https://cursos.alura.com.br/course/threads-java-1
        
        Tópicos:
        • Introdução à Threads Ver primeiro vídeo
        • Ordem de execução
        • Sincronizando a execução
        • Coleções thread-safe
        • Espere e notifique
        • Revisitando a lista
        • Entendendo Deadlock

##### Alura: Threads em Java 2: programação concorrente avançada (16h)
        Link: https://cursos.alura.com.br/course/threads-java-2
        
        Tópicos:
        • O projeto Servidor de tarefas
        • Reuso de threads
        • Melhorando o cliente
        • Entendendo Volatile
        • Distribuindo comandos e tratamento de erro
        • Retornos no Futuro
        • Produzindo e Consumindo com Threads
        
##### Youtube Loiane: https://youtube.com/playlist?list=PL3JzGmlyufwQ7DowZJzeux57gzuQM_iSR&si=EnSIkaIECMiOmarE

###### Anotações:
• O que é? (um descrição simples)
        
        É o que permite que nosso programa tenha mais de um fluxo, ou seja, nosso programa passa a ter ações simultaneas/paralelas.

• Como usar? (Como coloco na minha aplicação/dia-a-dia)
        
        Maneiras diferentes de instanciar a minha thread na aplicação:
        
        #1 Extendendo a Classe Thread no Objeto:
        
        public class MinhaThread extends Thread {

                private String nome;

                public MinhaThread(String nome) {
                        this.nome = nome;
                        start();
                }

                public void run() {
                        System.out.println("Executando a Thread");
                }
        }
        
        #2 Implementando a interface Runnable no objeto e instanciando a Thread no construtor:
        
        public class MinhaThread implements Runnable {

                private String nome;

                public MinhaThread(String nome) {
                        this.nome = nome;
                        Thread t = new Thread(this);
                        start();
                }

                @Override
                public void run() {
                        System.out.println("Executando a Thread");
                }
        }
        
        #3 Implementando a interface Runnable no objeto e instancia a Thread no Main:
        
        NO OBJETO:
        
        public class MinhaThread implements Runnable {

                private String nome;

                public MinhaThread(String nome) {
                        this.nome = nome;
                }

                public void run() {
                        System.out.println("Executando a Thread");
                }
        }
        
        NO MAIN:
        
        Thread threadUm = new Thread(new MinhaThread(nome),"ThreadUm").start();
        
        
• Pra que serve? (qual problema resolve)
        
        Usamos apra que nossa aplicação execute tarefas de forma paralela, impedindo que o usuario fique "travado" tornando a experiencia de uso melhor.

• Quando usar? (qual problema/requisito identifico antes de aplicar a solução)
        
        Quando nossa aplicação executa muitas tarefas, separados as tarefas em modulos (threads) para que elas possam ser executadas ao mesmo tempo.

• Existe algo parecido ou igual? (o que existe que serve para a mesma coisa/resolve o mesmo problema de outra forma ou parecida)
        
        *Não encontrei.

• De onde é? (biblioteca, onde está a doc dessa ferramenta)
        
        Doc Oracle: https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html
        Referencia W3Schools: https://www.w3schools.com/java/java_threads.asp

**Artigos com breves explicações:
        
        Programação com Threads: https://www.devmedia.com.br/programacao-com-threads/6152
        Trabalhando com Threads em Java: https://www.devmedia.com.br/trabalhando-com-threads-em-java/28780


#### Anotações Extras - Especificas.

•• Thread Pool = Piscina de threads. ••

Reuso de threads, como tem um alto custo computacional criar cada thread o reuso fornece mais ganho de custo.
Para criar uma piscina de threads usamos o Executors.newfixedThreadPool(n); [n=numero de vezes que quero reutilizar essa thread]. Para isso precisamos instanciar/criar o objeto: ExecutorService nomex = Executors.newfixedThreadPool(n);
Usaremos também o pool no lugar do start, assim: nomex.execute(ClasseTarefa); 
Assim temos o numero fixo de threads disponiveis, podemos fazer de uma outra forma, não limitando a quantidade de threads que teremos, assim não ficaremos limitados. Basta usar newCachedThreadPool() no lugar do newfixedThreadPool(n) na instancia.Ficando assim: ExecutorService nomex = Executors.newCachedThreadPool();


•• Volatile ••

Cada thread nativamente tem sua memoria, seu cache, nos queremos que as threads tenham essa memoria compartilhada, que eles puxem a memoria principal. Para isso é basicamente adicionar o volatile no atributo que deve ter esse cache compartilhado.
Exemplo: Eu tenho um boolean que será manipulado em varios metodos e ele precisa ter seu status compartilhado e alterado entre esses metodos:
	private volatile boolean atributo = false;
No novo pacote java foi criado uma variavel que substitui o uso do volatile[também não precisaremos de synchronized], eu poderia também para que tenha a mesma função usar esse atributo da seguinte forma:
	private AtomicBoolean atributo;
Mas como é uma classe não podemos usar de modo primitivo, então no nosso construtor temos que instancias com:
	this.atributo = new AtomicBoolean();
E ao chama-lo usamos como uma classe, por exemplo preciso chamar o valor booleano do meu atributo, então usarei o get:
	this.atributo.get();
E quando preciso alterar o valor da minha variavel uso o set:
	this.atributo.set(novoValor); [*novoValor = true or false]
Vem do pacote: java.util.concurrent.atomic
Podemos usar também: AtomicInteger e AtomicLong
referencia de documentação: https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/atomic/AtomicBoolean.html 


•• Tratamento de exceções ••

O tratamento de exceção deve estar na mesma pilha onde existe a exceção, ou seja, se quero tratar uma exceção que vai existir no metodo run, devo fazer o tratamento dela dentro do mesmo metodo. Mas isso não é escalavel, ou seja, se eu tiver um projeto com 50 metodos teria que fazer tratativas exclusivas para cada um, para resolver esse problema usamos o setUncaughExceptionHandler( ); que eu instancio junto com meu objeto, no caso podemos fazer assim:
1- Criar um novo objeto:
Thread thread = new Thread(new Runnable() { colocar tudo da minha thread aqui dentro } );
2- Chamar o set nesse objeto:
thread.setUncaughExceptionHandler( new ClasseTratamentoDeExcecao());
*A classe ClasseTratamentoDeExcecao deve implementar o UncaughExceptionHandler:
public class ClasseTratamentoDeExcecao implements UncaughExceptionHandler { }
*Quando criamos threadPool não conseguimos usar o setUncaughExceptionHandler, para isso, precisaremos precisamos ir onde criamos o atributo threadPool e mudar a instancia dele, usaremos a opção que recebe o newFixedThreadPool + threadFactory, basta ir no construtor e fazer:
this.threadPool = Executors.newFixedThreadPool(0, new ClasseCriadoraDeThreads);
*ClasseCriadoraDeThreads = Classe que implementa ThreadFactory: public class ClasseCriadoraDeThreads implements ThreadFactory {} Essa classe cria o metodo newThread, que é onde oficialmente vamos instanciar a ClasseTratamentoDeExcecao.
Em resumo, para tratar exceções de threads usando o threadPool precisamos de mais 2 arquivos no projeto: 1- Classe que trata a exceção, que implementa o UncaughExceptionHandler | 2- Classe que "cria threads" que implementa o ThreadFactory. Agora, se está instanciando uma thread unica, basta criar o arquivo 1 e utilizar o setUncaughExceptionHandler normalmente.


•• Como fazer nossas Threads retornar informações ••

Na classe de retorno, no lugar de implementar o Runnable, usaremos o Callable<>, ao usar o Callable, ele exige que você diga qual o tipo do retorno essa classe vai oferecer, então, usaremos:
public class ClasseQueRetorna implements Callable<String> (usando o String como exemplo)(dentro do <> caso não queira retornar nada, o que perde o sentido de usar o Callable, mas caso seja necessario, temos o generics Void disponivel)
Outra mudança, é que no lugar do metodo run() usaremos o metodo call(), e diferente do anterior, o call não é void, e sim o tipo de retorno que você colocar no implements da classe, ou seja, nesse exemplo usaremos:
public String call() {}
E por fim, outra diferença importante nessa introdução, é o tratamento de exceção, por exemplo, ao fazermos um Thread.sleep() em uma interface Runnable, sempre é necessario criar o tratamento para essa chamada, nos nossos exemplos usavamos o try...catch, com a interface Callable<> o nosso metodo call aceita throws na sua contrução, então, no lugar de criar um try...catch para cada chamada que precisa de tratamento, podemos usar:
public String call() throws Exception {}
*todo metodo call() precisa de um return.
*o metodo execute() é exclusivo do Runnable, no Callable<> usamos o submit()
•Usando Future<> : precisamos encontrar o meio de mostrar o resultado das nossas chamadas, seja do banco ou de um webservice, para uso usamos a interface Future que é a representação de um resultado, ele pode ser usado tanto para interfaces Runnable quanto em Callable. Usa implementação acontece na chamada do execute ou submit, da seguinte forma:
Future<String> nomeQualquer =  this.threadPool.submit(nomeInstanciaClasseComandoAcao);
E mostramos o resultado atraves da chamada pelo get mesmo:
String nomeString = nomeQualquer.get(); ((nomeQualquer = nome dado na instancia da nossa Future)).


•• Filas de Comandos / Collection Queue ••

Mini overview de Filas:
Vindo do java util collection temos o queue, que são as filas. Como implementamos filas:
Queue<TipoDeDado> nomeFila =  new LinkedList<>(); (Queue<String>  | Queue<Int> | etc)
- Oferecendo dados, inserindo dado na fila:
	nomeFila.offer("Informação");
- Recebendo dados, e tirando o dado da fila:
	nomeFila.poll();
- Recebendo dados mas sem retira-lo da fila:
	nomeFila.peek();
O LinkedList não foi criado para programação concorrente, ou seja, ele não vai funcionar nas threads, para isso, temos uma solução, o BlockingQueue, fazendo um paralelo ao funcionamento vimos algumas anotações acima o Atomic, a implementação é parecida, então, para utiliza-los:
BlockingQueue<String> nomeFila = new ArrayBlockingQueue<>(n);
*Por que usar o ArrayBlockingQueue<>(n)? (n=quantidade de elementos que quero na minha fila, numero inteiro) O LinkedList não é compativel com o Blocking, além do array temos algumas outras opções, referencia de doc: https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/BlockingQueue.html
*Usamos no lugar do poll o take: nomeFila.take(); Ele bloqueia a thread até que o elemento fique disponivel, ou seja, vai pausar até que tenha o conteudo.
*Usamos no lugar do offer o put: nomeFila.put("Dado"); Ele bloqueia a execução aguardando um espaço caso seja feita uma tentativa de adição com a fila cheia.


•• Suspender, Parar e Rotomar ••

Atualmente só é possivel fazer esses movimentos com as threads de forma, digamos, manual. Após do java 2 os metodos suspend, stop e resume, que pertenciam a classe thread, foram excluidos, mas ainda podemos montar essas ações. Para isso criamos os metodos da classe, e com o auxilio de booleans que usaremos como flags podemos fazer o controle das threads.
-Criando os boobleans:
boolean estaSuspensa; 
boolean foiTerminada;
-Criando os metodos:
void suspend() { 
		this.estaSuspensa = true;
	}
	
synchronized void resume() {
	this.estaSuspensa = false;
	notify(); 
}
	
synchronized void stop() {
	this.foiTerminada = true;
	notify();
}


•• DEADLOCKS ••

É o impasse causado quando a execução de uma thread impede a execução de outra.
Como podemos evitar: Usando metodos wait e notify nos synchronized.
