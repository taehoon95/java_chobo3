package java_chobo3.ch14.stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;

public class StreamFinalEx4 {
	public static void main(String[] args) {
//		new Student2(name, isMale, hak, ban, score)

		Student2[] stuArr = { new Student2("나자바", true, 1, 1, 300), new Student2("김지미", false, 1, 1, 250),
				new Student2("김자바", true, 1, 1, 200), new Student2("이지미", false, 1, 2, 150),
				new Student2("남자바", true, 1, 2, 100), new Student2("안지미", false, 1, 2, 50),
				new Student2("황지미", false, 1, 3, 100), new Student2("강지미", false, 1, 3, 150),
				new Student2("이자바", true, 1, 3, 200), new Student2("나자바", true, 2, 1, 300),
				new Student2("김지미", false, 2, 1, 250), new Student2("김자바", true, 2, 1, 200),
				new Student2("이지미", false, 2, 2, 150), new Student2("남자바", true, 2, 2, 100),
				new Student2("안지미", false, 2, 2, 50), new Student2("황지미", false, 2, 3, 100),
				new Student2("강지미", false, 2, 3, 150), new Student2("이자바", true, 2, 3, 200) };

		Map<Boolean, List<Student2>> stdBySex = Arrays.stream(stuArr).collect(partitioningBy(Student2::isMale));

		List<Student2> maleStds = stdBySex.get(true);
		System.out.println("남학생 : " + maleStds);

		List<Student2> femaleStds = stdBySex.get(false);
		System.out.println("여학생 : " + femaleStds);

		Map<Boolean, Long> stdNumBySex = Arrays.stream(stuArr).collect(partitioningBy(Student2::isMale, counting()));
		System.out.printf("남학생 수 %d 여학생수 %d%n", stdNumBySex.get(true), stdNumBySex.get(false));

		Map<Boolean, Optional<Student2>> topScoreBySex = Arrays.stream(stuArr)
				.collect(partitioningBy(Student2::isMale, maxBy(comparingInt(Student2::getScore))));
		System.out.println("남학생 1등:" + topScoreBySex.get(true));
		System.out.println("여학생 1등:" + topScoreBySex.get(false));

		Map<Boolean, Student2> topScoreBySex2 = Arrays.stream(stuArr).collect(partitioningBy(Student2::isMale,
				collectingAndThen(maxBy(comparingInt(Student2::getScore)), Optional::get)));
		System.out.println("남학생 1등:" + topScoreBySex2.get(true));
		System.out.println("여학생 1등:" + topScoreBySex2.get(false));

		Map<Boolean, Map<Boolean, List<Student2>>> failedStuBySex = 
				Arrays.stream(stuArr)
				.collect(partitioningBy(Student2::isMale
						, partitioningBy(s -> s.getScore() < 150)
						));
		List<Student2> failedMaleStu = failedStuBySex.get(true).get(true);
		List<Student2> failedFemaleStu = failedStuBySex.get(false).get(true);
		System.out.printf("불합격 남학생 : %s%n불합격 여학생 : %s%n", failedMaleStu, failedFemaleStu);

	}

}
