package java_chobo3.ch14.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class StreamStatEx {
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
		
		List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10); // 리스트로 변환
		
		long cnt1 = list.stream().count();
		long cnt2 = intList.stream().count();
		System.out.printf("list cnt = %d, intList cnt = %d%n",cnt1 ,cnt2);
		
		Optional<Student> optStd = list.stream().max(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getTotalScore() - o2.getTotalScore();
			}
		});
		
		Optional<Student> optStd2 = list.stream().min((o1,o2) -> o1.getTotalScore() - o2.getTotalScore());
		System.out.println("max Student " + optStd);
		System.out.println("min Student " + optStd2);
		
		Optional<Student> optStd3 = list.parallelStream().min((o1,o2) -> o1.getTotalScore() - o2.getTotalScore());
		System.out.println("parallelStream min Student" + optStd3);
		
		int[] arr = {1,2,3,4,5,6,7,8,9,10};	
		IntStream intStream = IntStream.of(arr); //intStream에 값넣기
		
		int sum = intStream.sum();
		OptionalDouble avg = IntStream.of(arr).average();
		OptionalInt max = IntStream.of(arr).max();
		OptionalInt min = IntStream.of(arr).min();
		
		System.out.printf("sum = %d, avg = %.2f, max = %d, min = %d%n"
				, sum, avg.getAsDouble(), max.getAsInt(), min.getAsInt());
		
		IntSummaryStatistics summary = IntStream.of(arr).summaryStatistics();
		System.out.printf("count = %d, sum = %d, avg = %.2f, max = %d, min = %d%n",
				summary.getCount(),
				summary.getSum(),
				summary.getAverage(),
				summary.getMax(),
				summary.getMin()
				);
	}
}

