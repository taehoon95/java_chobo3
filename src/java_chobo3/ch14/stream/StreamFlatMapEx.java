package java_chobo3.ch14.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public class StreamFlatMapEx {

	public static void main(String[] args) {
		String[][] strArrs = {
					{"abc","def","jkl"},
					{"ABC","GHI","JKL"}
		};
		Stream<String[]> strArrStream = Stream.of(strArrs);
		Stream<Stream<String>> strStreamStream = strArrStream.map(Arrays::stream);
		strStreamStream
		.peek(s-> System.out.println(s))
		.forEach(System.out::println);
		
		
		
		strArrStream = Stream.of(strArrs);
		Stream<String> strStream = strArrStream.flatMap(Arrays::stream);
		strStream.map(String::toLowerCase)
		.distinct()
		.sorted()
		.forEach(System.out::println);
		
	}
}
