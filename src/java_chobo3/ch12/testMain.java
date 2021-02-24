package java_chobo3.ch12;

import java.util.ArrayList;

public class testMain {

	public static void main(String[] args) {
		Box<String> box = new Box<String>();
		
		box.add("abc");
		box.add("def");	
//		box.add(new Object()); // 에러뜸

		String item = box.get(0);
		System.out.println("item > " + item);
		
		ArrayList<String> list =  box.getList();
		list.stream().forEach(System.out::println);
		
		System.out.println(box);
	}

}
