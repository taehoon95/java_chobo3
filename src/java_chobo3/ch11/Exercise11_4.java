package java_chobo3.ch11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Exercise11_4 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student2("이",2,1));
		list.add(new Student2("안",2,2));
		list.add(new Student2("홍",1,3));
		list.add(new Student2("남",1,1));
		list.add(new Student2("김",1,2));
		
		Collections.sort(list, new BanNoAsending());
		
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
