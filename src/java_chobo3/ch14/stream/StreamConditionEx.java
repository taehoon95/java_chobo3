package java_chobo3.ch14.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamConditionEx {
	
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("이자바",3,300));
		list.add(new Student("김자바",2,200));
		list.add(new Student("인자바",2,210));
		list.add(new Student("박자바",1,100));
		list.add(new Student("소자바",2,95));
		list.add(new Student("나자바",1,280));
		list.add(new Student("조자바",2,60));
		list.add(new Student("지자바",3,80));
		
		matchEx(list);
		
		findEx(list);
	}

	private static void findEx(List<Student> list) {
		Stream<Student> stdStream = list.stream();
		
		Optional<Student> result = stdStream.filter(s -> s.getTotalScore() <= 100).findFirst();
		System.out.println(result);
		
		result = list.parallelStream().filter(s -> s.getTotalScore() <= 100).findAny();
		System.out.println(result);
		
	}

	private static void matchEx(List<Student> list) {
		Stream<Student> stdStream = list.stream();
		
		boolean hasRes = stdStream.anyMatch(new Predicate<Student>() {

			@Override
			public boolean test(Student t) {
				return t.getTotalScore() < 100;
			}
		});
		System.out.printf("getTotalScore() < 100 hasRes => %s%n", hasRes );
		
		stdStream = list.stream();
		hasRes = stdStream.allMatch(s -> s.getTotalScore() >= 60);
		System.out.printf("getTotalScore() >= 60 hasRes => %s%n", hasRes );
		
	}
}
