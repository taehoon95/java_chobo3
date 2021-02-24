package java_chobo3.ch09;

public class ExSC {

	public static void main(String[] args) {
		String str = "aabbccAABBCCaa";
		System.out.println(str);
		StringCount sc = new StringCount(str);
		System.out.println("aa를 "+ sc.stringCount("aa")+"개 찾았습니다.");
	}

}
