package java_chobo3.ch13;

public class Thread3 implements Runnable {
	static boolean autoSave = false;
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			if(autoSave) {
				autoSave();
			}
		}
		
	}

	private void autoSave() {
		System.out.println("작업 파일이 자동 저장 되었습니다.");
		
	}

}
