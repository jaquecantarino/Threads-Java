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
        • 
        •
        • 
        • 
        • 
        
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



*Thread Pool = Piscina de threads.
Reuso de threads, como tem um alto custo computacional criar cada thread o reuso fornece mais ganho de custo.
Para criar uma piscina de threads usamos o Executors.newfixedThreadPool(n); [n=numero de vezes que quero reutilizar essa thread]. Para isso precisamos instanciar/criar o objeto: ExecutorService nomex = Executors.newfixedThreadPool(n);
Usaremos também o pool no lugar do start, assim: nomex.execute(ClasseTarefa); 
Assim temos o numero fixo de threads disponiveis, podemos fazer de uma outra forma, não limitando a quantidade de threads que teremos, assim não ficaremos limitados. Basta usar newCachedThreadPool() no lugar do newfixedThreadPool(n) na instancia.Ficando assim: ExecutorService nomex = Executors.newCachedThreadPool();
