package java_chobo3.ch13;

class Thread04 extends Thread{
	public void run() {
		for(int i = 10; i > 0;i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class ThreadEx03 {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < 300; i++) {
			System.out.printf("%s", new String("-"));
		}
		System.out.println();
		System.out.printf("%s %d 초%n", "첫번째 작업", System.currentTimeMillis() - startTime);

		for (int i = 0; i < 300; i++) {
			System.out.printf("%s", new String("|"));
		}
		System.out.println();
		System.out.printf("%s %d 초%n", "두번째 작업", System.currentTimeMillis() - startTime);

	}
}
