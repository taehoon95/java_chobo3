package java_chobo3.ch14.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFinalEx3 {
	
	public static void main(String[] args) {
		
		
		//스트림을 reducing
		OptionalInt maxValue = new Random(1234)
				.ints(1,46).distinct().limit(6)
				.peek(s -> System.out.print(s + " ,"))
				.reduce(Integer::max);
		System.out.println("max = " + maxValue.getAsInt());

		Optional<Integer> maxValue2 = new Random(1234)
				.ints(1,46).distinct().limit(6) //IntStream
				.boxed()						//Stream<Integer>
				.peek(s -> System.out.print(s + " ,"))
				.collect(Collectors.reducing(Integer::max));

		System.out.println("max2 = " + maxValue2.get());
		
		int sum1 = new Random(1234)
				.ints(1,46)
				.distinct()
				.limit(6)
				.reduce(0, (a,b) -> a+b);
		
		int sum2 = new Random(1234)
				.ints(1,46)
				.distinct()
				.limit(6)
				.boxed()
				.collect(Collectors.reducing(0, (a,b) -> a+b));
		
		System.out.printf("sum1 = %d, sum2 = %d%n", sum1,sum2);
		
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("이자바", 3, 300));
		list.add(new Student("김자바", 2, 200));
		list.add(new Student("인자바", 2, 210));
		list.add(new Student("박자바", 1, 100));
		list.add(new Student("소자바", 2, 150));
		list.add(new Student("나자바", 1, 280));
		list.add(new Student("조자바", 2, 220));
		list.add(new Student("지자바", 3, 300));
		
		Integer grandTotal1 = list.parallelStream()
				.map(Student::getTotalScore)
				.reduce(0, Integer::sum);
		System.out.println(grandTotal1);
		
		Integer grandTotal2 = list.parallelStream()
				.collect(Collectors.reducing(0, Student::getTotalScore, Integer::sum));
		System.out.println(grandTotal2);
		
		//문자열스트림을 모두 연결 (Joining)
		String names1 = list.parallelStream().map(Student::getName).collect(Collectors.joining());
		String names2 = list.parallelStream().map(Student::getName).collect(Collectors.joining(","));
		String names3 = list.parallelStream().map(Student::getName).collect(Collectors.joining(",","[","]"));
		
		System.out.println(names1);
		System.out.println(names2);
		System.out.println(names3);
		
		
	}
}
