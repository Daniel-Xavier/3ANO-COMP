package prodcon;

class Consumer extends Thread {
	// Referência para buffer compartilhado
	Buffer buffer;

	// Construtor
	public Consumer(Buffer buffer) {
		super("CONSUMIDOR");
		this.buffer = buffer;
	}

	// Método redefinido que executa a função da thread
	@Override
	public void run() {
		try {
			// Tenta consumir um número inteiro
			while (true) {
				buffer.get();
				this.yield();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
