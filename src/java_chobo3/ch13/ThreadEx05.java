package java_chobo3.ch13;

import javax.swing.JOptionPane;
class Thread03 extends Thread{
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
public class ThreadEx05 {
	public static void main(String[] args) {
		Thread03 thread = new Thread03();
		thread.start();
		
		String input = JOptionPane.showInputDialog("아무값이나 입력");
		System.out.println("입력한 값은 " + input + "입니다.");
	}

}
