package java_chobo3.ch13;

public class ThreadEx07 {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Thread3());
		t1.setDaemon(true);
		t1.start();
		
		for(int i = 1; i < 11; i++) {
			Thread.sleep(1000);
			System.out.println(i);
			
			if(i == 5) Thread3.autoSave = true;
		}
		
		System.out.println("프로그램 종료");
	}

}
