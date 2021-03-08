package java_chobo3.ch14.stream;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamForEachToArrayEx {
	public static void main(String[] args) {
		IntStream.range(1, 10).sequential().forEach(new IntConsumer() {
			
			@Override
			public void accept(int value) {
				System.out.print(value);
			}
		});
		System.out.println();
		
//		IntStream.range(1, 10).parallel().forEach(System.out::print); //순서보장X
		IntStream.range(1, 10).parallel().forEach(s -> System.out.print(s));
		System.out.println();
		
		IntStream.range(1, 10).parallel().forEachOrdered(System.out::print); //순서보장
		System.out.println();
		
		Student[] stdArr = {new Student("김인환", 1, 280),
				new Student("이태훈", 1, 270),
				new Student("김상건",2,260),
				new Student("전수린",2,250)
		};
		Stream<Student> studentStream = Arrays.stream(stdArr);
		
		Student[] tempArr = studentStream.toArray(Student[]::new);
		System.out.println(Arrays.toString(tempArr));
		
		studentStream = Arrays.stream(stdArr);
		Object[] objArr = studentStream.toArray();
		System.out.println(Arrays.toString(objArr));
		
	}
}
