package java_chobo3.ch14.stream;

import java.util.Comparator;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MidStreamEx {
	public static void main(String[] args) {
		// 중간연산
//		extracted01(); //skip,limit.filter,distinct
		
		// sorted
//		extracted02();
		
		// Student
		extracted03();
	}


	public static void extracted03() {
		Stream<Student> stdStream = Stream.of(
				new Student("이자바",3,300),
				new Student("김자바",2,200),
				new Student("인자바",2,210),
				new Student("박자바",1,100),
				new Student("소자바",2,150),
				new Student("나자바",1,280),
				new Student("조자바",2,220),
				new Student("지자바",3,300)
				);
		
		stdStream.sorted(Comparator.comparing(Student::getBan)
				.thenComparing(Comparator.naturalOrder())) //thenComparing 위에거 정렬하고 나서 또 정렬해라
				.forEach(System.out::println);
		
		
//		stdStream.sorted(Comparator.comparing(Student::getBan)
//				.thenComparing(Student::getTotalScore) //thenComparing 위에거 정렬하고 나서 또 정렬해라
//				.forEach(System.out::println);
	}


	public static void extracted02() {
		Stream<String> strStream = Stream.of("dd","aaa","CCC","cc","b");
		strStream.sorted()
		.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		Stream.of("dd","aaa","CCC","cc","b") // 일회용이라 계속 만들어줌
		.sorted(Comparator.naturalOrder())   // 기본정렬
		.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		Stream.of("dd","aaa","CCC","cc","b")
		.sorted((s1,s2) -> s1.compareTo(s2)) //람다식 사용
		.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		Stream.of("dd","aaa","CCC","cc","b")
		.sorted(String::compareTo)	         //위의 문장들과 동일
		.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		Stream.of("dd","aaa","CCC","cc","b")
		.sorted(Comparator.reverseOrder())   //역순정렬
		.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		Stream.of("dd","aaa","CCC","cc","b")
		.sorted(String.CASE_INSENSITIVE_ORDER) //대소문자 구분없이
		.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		Stream.of("dd","aaa","CCC","cc","b")
		.sorted(String.CASE_INSENSITIVE_ORDER.reversed()) //대소문자 구분없이 역순정렬
		.forEach(s -> System.out.print(s + " "));
		System.out.println();
	}
	

	public static void extracted01() {
		// 중간연산
		// 1. skip(), limit()
		System.out.println("중간연산  - 1.skip(), limit() ");
		IntStream.rangeClosed(1, 10).skip(3).limit(5).forEach(s -> System.out.print(s + " "));
		System.out.println();

		// 2.filter, distinct()
		System.out.println("중간연산  - 2.fillter(), distinct() ");
		IntStream.of(1, 2, 2, 3, 3, 3, 4, 5, 5).distinct().forEach(s -> System.out.print(s + " "));
		System.out.println();

		IntStream.rangeClosed(1, 20).filter(i -> i % 2 == 0).forEach(s -> System.out.print(s + " "));
		System.out.println();

		IntStream.rangeClosed(1, 20).filter(i -> i % 2 == 0).filter(i -> i % 3 == 0)
				.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		
		IntPredicate p = t -> t % 2 == 0;
		IntStream.rangeClosed(1, 20).filter(p)
		.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		
//		IntPredicate test = new IntPredicate() {
//			
//			@Override
//			public boolean test(int value) {
//				return value % 2 == 0;
//			}
//		};
//		->> 람다식으로 변환
//		IntPredicate test = value -> value % 2 == 0;
	}
}
