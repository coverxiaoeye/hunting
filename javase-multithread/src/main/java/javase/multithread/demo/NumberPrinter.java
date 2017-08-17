package javase.multithread.demo;

/**
 * 也能实现三个线程轮流打印5个数，直到75，但是原理没太琢磨透。。。
 * @author wangyg
 *
 */
class NumberPrinter extends Thread {
	static int c = 0;
	static int state = 0;
	private int id;

	@Override
	public synchronized void run() {
		while (state < 15) {
			if (state % 3 == id) {
				for (int j = 0; j < 5; j++) {
					c++;
					System.out.format("Thread %d: %d %n", id, c);
				}
				state++;
			}
		}
	}

	public NumberPrinter(int id) {
		this.id = id;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			new NumberPrinter(i).start();
		}
	}
}