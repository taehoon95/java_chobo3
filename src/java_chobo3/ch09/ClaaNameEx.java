package java_chobo3.ch09;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ClaaNameEx {

	public static void main(String[] args) {
		Point p = new Point(4, 5);
	
		Class<?>obj = p.getClass();
     	Constructor<?>[] cons = obj.getConstructors();
	
     	for(Constructor<?> c : cons) {
     		System.out.println(c);
     	}
	
     	for(Method m : obj.getDeclaredMethods()) {
     		System.out.println(m);
     	}
	}

}
