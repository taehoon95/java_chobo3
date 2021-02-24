package java_chobo3.ch13;

public class Thread02 implements Runnable {

	@Override
	public void run() {
		for(char ch = 'a' ; ch <= 'z' ; ch++) {
			System.out.println(ch);
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
