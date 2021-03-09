package java_chobo3.ch14.stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Stream;


public class StreamFinalEx5 {

	public static void main(String[] args) {
		Student2[] stuArr = { 
				new Student2("나자바", true, 1, 1, 300),
				new Student2("김지미", false, 1, 1, 250),
				new Student2("김자바", true, 1, 1, 200),
				new Student2("이지미", false, 1, 2, 150),
				new Student2("남자바", true, 1, 2, 100),
				new Student2("안지미", false, 1, 2, 50),
				new Student2("황지미", false, 1, 3, 100),
				new Student2("강지미", false, 1, 3, 150),
				new Student2("이자바", true, 1, 3, 200),
				new Student2("나자바", true, 2, 1, 300),
				new Student2("김지미", false, 2, 1, 250),
				new Student2("김자바", true, 2, 1, 200),
				new Student2("이지미", false, 2, 2, 150),
				new Student2("남자바", true, 2, 2, 100),
				new Student2("안지미", false, 2, 2, 50),
				new Student2("황지미", false, 2, 3, 100),
				new Student2("강지미", false, 2, 3, 150),
				new Student2("이자바", true, 2, 3, 200) 
				};
		
		//학생목록에서 반별로 그룹화
		Map<Integer, List<Student2>>stdByBan = 
		Stream.of(stuArr)
		.collect(groupingBy(Student2::getBan));
		
		for(Entry<Integer, List<Student2>> e : stdByBan.entrySet()) {
			System.out.printf("%d반 %s%n", e.getKey(),e.getValue());
		}
		
		//다중 그룹화(학년, 반)
		Map<Integer, Map<Integer, List<Student2>>> stdHakAndBan=  
		Stream.of(stuArr)
		.collect(
				groupingBy(
						Student2::getHak // 학년별 구분
						,groupingBy(Student2::getBan)) // 같은 학년에서 반별 구분
				);
		for(Entry<Integer, Map<Integer, List<Student2>>> e : stdHakAndBan.entrySet()) {
			System.out.println(e.getKey()+"학년 ");
			 Map<Integer, List<Student2>> values = e.getValue();
			for(Entry<Integer, List<Student2>> subE : values.entrySet()) {
				System.out.println(subE.getKey()+"반");
				System.out.println(subE.getValue());
			}
		}
		
		//모든 학생을 세등급(HIGH, MID, LOW)로 카운팅
		Map<Level, Long> stdByLevel = 
		Stream.of(stuArr)
		.collect(
				groupingBy(
						s -> {
							if(s.getScore() >= 200)
								return Level.HIGH;
							else if(s.getScore() >= 100)
								return Level.MID;
							else 
								return Level.LOW;
						},
						counting()
					)
			);
		for(Entry<Level, Long> e : stdByLevel.entrySet()) {
			System.out.println(e.getKey() + " " + e.getValue());
		}
		System.out.println("HiGH : " + stdByLevel.get(Level.HIGH) + "명");
		System.out.println("MID  :  " + stdByLevel.get(Level.MID) + "명");
		System.out.println("LOW  :  " + stdByLevel.get(Level.LOW) + "명");
		//모든 학생을 세등급(HIGH, MID, LOW)로 Set으로 저장
	
	}

}
