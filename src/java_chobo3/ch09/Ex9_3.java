package java_chobo3.ch09;

public class Ex9_3 {

	public static void main(String[] args) {
		String str1 = new String("abc");
		String str2 = new String("abc");
		
		System.out.println(str1.equals(str2));
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		
		String str3 = "abc";
		String str4 = "abc";
		
		System.out.println(System.identityHashCode(str3));
		System.out.println(System.identityHashCode(str4));
		
		
	}

}
