package java_chobo3.ch09;

public class StringEx {

	public static void main(String[] args) {
		String str = "ab,cd,ef";
		String[] ar = str.split(",");
		for(String e : ar) {
			System.out.println(e);
		}
	}

}
