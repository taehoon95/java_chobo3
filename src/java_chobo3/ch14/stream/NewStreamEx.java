package java_chobo3.ch14.stream;

import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.IntStream;

public class NewStreamEx {

	public static void main(String[] args) {
		IntStream.range(1, 10).forEach(System.out::print);
		System.out.println();
		IntStream.rangeClosed(1, 10).forEach(System.out::print);
		
		System.out.println();
		//난수를 요소로
		new Random(1234).ints().limit(5).sorted().forEach(System.out::println);
		System.out.println();
		System.out.printf("ints() range => %d ~ %d%n",Integer.MIN_VALUE, Integer.MAX_VALUE);
		
		new Random(1234).ints(5).sorted().forEach(System.out::println);
		
		
	}
}
