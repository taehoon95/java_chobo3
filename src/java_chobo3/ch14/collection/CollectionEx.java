package java_chobo3.ch14.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class CollectionEx {

	public static void main(String[] args) {
		ArrayList<Integer> arList = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			arList.add(i);
		}
		
		for(int i : arList) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		Consumer<Integer> c = new Consumer<Integer>() {
			
			@Override
			public void accept(Integer t) {
				System.out.print(t+" ");
			}
		};
		Consumer<Integer> d = i -> System.out.print(i + " ");
		
		arList.forEach(c);
		System.out.println();
		
		arList.forEach(d);
		System.out.println();
		
		arList.forEach(i->System.out.print(i+" "));
		System.out.println();
		//List 에서 2 또는 3의 배수를 제거
		arList.removeIf(x -> x % 2 == 0 || x % 3 == 0);
		arList.forEach(i->System.out.print(i+" "));
		
		System.out.println();
		
		Predicate<Integer> p1 = i -> i % 2 == 0;
		Predicate<Integer> p2 = i -> i % 3 == 0;
		
		Predicate<Integer> p3 = p1.or(p2);
		
		ArrayList<Integer> arList2 = new ArrayList<Integer>();
		
		for(int i = 0; i < 10; i++) {
			arList2.add(i);
		}
		arList2.forEach(i->System.out.print(i+" "));
		System.out.println();
		
		arList2.removeIf(p3);
		arList2.forEach(i->System.out.print(i+" "));
		System.out.println();
		
		UnaryOperator<Integer> v = new UnaryOperator<Integer>() {
			
			@Override
			public Integer apply(Integer t) {
				return t * 10;
			}
		};
		arList.replaceAll(v);
		arList.forEach(i ->System.out.print(i + " "));
		System.out.println();
		
		UnaryOperator<Integer> u = i -> i * 10;
		arList2.replaceAll(u);
		arList2.forEach(i->System.out.print(i + " "));
		System.out.println();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("1","a");
		map.put("2","b");
		map.put("3","c");
		map.put("4","d");
		
		System.out.println();
		for(Entry<String, String> e : map.entrySet()) {
			System.out.printf("{%s -> %s}%n" , e.getKey(),e.getValue());
		}
		System.out.println();
		for(String key : map.keySet()) {
			System.out.printf("{%s -> %s}%n" , key, map.get(key));
		}
		System.out.println();
		
		BiConsumer<String, String> w = new BiConsumer<String, String>() {
			
			@Override
			public void accept(String t, String u) {
				System.out.printf("{%s -> %s}%n",t,u);
			}
		};
		map.forEach(w);
		System.out.println();
		map.forEach((key,value)-> System.out.printf("{%s -> %s}%n",key,value));
	}
}
