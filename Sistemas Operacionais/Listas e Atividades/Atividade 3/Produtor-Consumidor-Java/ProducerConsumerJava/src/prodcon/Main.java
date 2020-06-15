package prodcon;

// Adaptado de https://javarevisited.blogspot.com/2015/06/java-lock-and-condition-example-producer-consumer.html
public class Main {

	public static void main(String[] args) {
		// Cria o buffer compartilhado
		Buffer buffer = new Buffer();
		// Cria as threads de produtor e consumidor
		Producer p = new Producer(buffer);
		Consumer c = new Consumer(buffer);
		// Inicializa as threads
		p.start();
		c.start();
	}

}
