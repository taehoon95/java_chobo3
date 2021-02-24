package java_chobo3.ch11;

import java.util.*;

public class Exercise11_3 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student2("홍",1));
		list.add(new Student2("남",1));
		list.add(new Student2("김",1));
		list.add(new Student2("이",1));
		list.add(new Student2("안",1));
		
		Collections.sort(list);
		
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}
}
