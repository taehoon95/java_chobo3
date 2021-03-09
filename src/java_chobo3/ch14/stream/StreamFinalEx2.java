package java_chobo3.ch14.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class StreamFinalEx2 {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("이자바",3,300));
		list.add(new Student("김자바",2,200));
		list.add(new Student("인자바",2,210));
		list.add(new Student("박자바",1,100));
		list.add(new Student("소자바",2,150));
		list.add(new Student("나자바",1,280));
		list.add(new Student("조자바",2,220));
		list.add(new Student("지자바",3,300));
		
		//스트림을 컬렉션으로 변환
//		extracted(list);
		
		//스트림의 통계정보
//		extracted2(list);
	}

	public static void extracted2(List<Student> list) {
		long cnt1 = list.stream().count();
		long cnt2 = list.stream().collect(Collectors.counting());
		System.out.println(cnt1);
		System.out.println(cnt2);
		
		int sum1 = list
				.parallelStream()
				.mapToInt(Student::getTotalScore)
				.peek(System.out::println)
				.sum();
		
		int sum2 = list
					.parallelStream()
					.collect(Collectors.summingInt(Student::getTotalScore));
		System.out.printf("totalScore %d ,%d%n", sum1, sum2);
		
		OptionalInt max1= list
							.parallelStream()
							.mapToInt(Student::getTotalScore)
							.peek(System.out::println)
							.max();
		
		System.out.printf("maxScore %d%n",max1.getAsInt());
		Optional<Student> maxStd1 = list
				.parallelStream()
				.max(Comparator.comparing(Student::getTotalScore));
		Student std = maxStd1.get();/*실제 객체 정보*/
		System.out.println(std);
		
		Optional<Student> maxStd2 = list.parallelStream()
		.collect(Collectors.maxBy(Comparator.comparing(Student::getTotalScore)));
		
		Student std1 = maxStd2.get();
		System.out.println(std1);
		
		IntSummaryStatistics iss1 = list.parallelStream()
										.mapToInt(Student::getTotalScore)
										.summaryStatistics();
		System.out.println(iss1);
		
		IntSummaryStatistics iss2 = list.parallelStream()
										.collect
										(Collectors.summarizingInt(Student::getTotalScore));
		System.out.println(iss2);
	}

	public static void extracted(List<Student> list) {
		
		List<String> stdList = list
								.stream()
								.map(Student::getName)
								.peek(System.out::println)
								.collect(Collectors.toList());
		System.out.println(stdList);
		
		ArrayList<Student> arList = list.stream()
									   .collect(Collectors.toCollection(ArrayList::new));
		System.out.println(arList);
		
		//Map<이름, 학생>
		Map<String, Student> map = list.stream()
				.collect(Collectors.toMap(s -> s.getName(), s->s));
		
		for(Entry<String, Student> e : map.entrySet()) {
			System.out.println(e.getKey() + " : " + e.getValue());
		}
	}

}
