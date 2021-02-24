package java_chobo3.ch08Exercise;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex8_1 {

	public static void main(String[] args) {
		int x = 0;
		int y = 0;
		int z = 0;
		Scanner input = new Scanner(System.in);
		try {
			x = input.nextInt();
			y = input.nextInt();
			z = x * y;
			System.out.printf("%d * %d = %d %n",x,y,z);
		}catch(InputMismatchException ex) {
			System.err.println("에러 메시지 : 정수를 입력해주세요");
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}

}
