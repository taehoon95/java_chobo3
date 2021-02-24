package java_chobo3.ch10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntUnaryOperator;

public class ArraysEx {

	public static void main(String[] args) {
//		arrayToString();
//		ArrayDeepToString();
//		arrayToEquals();
//		arrayToFill();
//		arrayToList();
//		arrayToBinarySearchBySort();

		Student[] stdArr = { new Student(1,"이종윤",90,90,90),
							 new Student(5,"김길현",80,79,68),
							 new Student(3,"박유진",78,91,55),
							 new Student(4,"김인환",99,60,40) };

		// 기본은 학번순으로 정렬
		Arrays.sort(stdArr);
		prnStudent(stdArr);
		

		// 국어점수별 정렬
		Comparator<Student> comp = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getKor() - o2.getKor();
			}
		};
		

		// 수학점수별 정렬
		Comparator<Student> revComp = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o2.getMath() - o1.getMath();
			}
		};
		Arrays.sort(stdArr, comp);
		prnStudent(stdArr);;
		Arrays.sort(stdArr, revComp);
		prnStudent(stdArr);;
	}

	private static void prnStudent(Student[] stdArr) {
		System.out.println("정렬");
		for(Student s : stdArr) {
			System.out.println(s);
		}
	}

	public static void arrayToBinarySearchBySort() {
		int[] arr = { 10, 9, 5, 6, 7, 8, 1 };
		System.out.println(Arrays.binarySearch(arr, 8));// 우연히 찾음
		System.out.println(Arrays.binarySearch(arr, 1));

		long start = System.nanoTime();

		System.out.println("start");
//		Arrays.sort(arr);
		Arrays.parallelSort(arr); // 병렬식이라 빠르다.
		long end = System.nanoTime() - start;
		System.out.println(end);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.binarySearch(arr, 8));// 우연히 찾음
		System.out.println(Arrays.binarySearch(arr, 1));
	}

	public static void arrayToList() {
		Integer[] intArr = new Integer[] { 1, 2, 3, 4 };

		List<Integer> arList = Arrays.asList(intArr);
		for (int a : arList) {
			System.out.println(a);
		}
		arList.set(1, 6);
		System.out.println(arList);
//		arList.add(10); // 크기를 정해놓았기 때문에 추가는 되지 않는다.
//		System.out.println(arList);
		ArrayList<Integer> al = new ArrayList<Integer>(arList); // ArrayList 로 변경하게 되면 다시 값을 넣을수 있다.
		al.add(10);
		System.out.println(al);
	}

	public static void arrayToFill() {
		// 배열 복사
		int[] intArr1 = { 1, 2, 3, 4, 5, 6 };
		int[] copyArr1 = Arrays.copyOf(intArr1, intArr1.length);
		System.out.println(Arrays.toString(copyArr1));
		System.out.println(Arrays.equals(intArr1, copyArr1));

		int[] copyArr2 = Arrays.copyOf(intArr1, 3);
		System.out.println(Arrays.toString(copyArr2));

		int[] newArr = new int[10];
		Arrays.fill(newArr, 10);

		System.out.println(Arrays.toString(newArr));

		Arrays.setAll(newArr, (i) -> (int) (Math.random() * 100) + 1);
//		Arrays.setAll(newArr, new IntUnaryOperator() {
//			
//			@Override
//			public int applyAsInt(int operand) {
//				return (int)(Math.random()*100)+1;
//			}
//		});
//		 람다식 사용방법
//		( parameters ) -> expression body
//		( parameters ) -> { expression body }
//		() -> { expression body }
//		() -> expression body
		System.out.println(Arrays.toString(newArr));
	}

	public static void arrayToEquals() {
		int[] intArr1 = { 1, 2, 3 };
		int[] intArr2 = { 1, 2, 4 };
		System.out.println(Arrays.equals(intArr2, intArr1));// 배열비교

		int[][] intTwoDimen1 = { { 1, 2 }, { 3, 4 } };
		int[][] intTwoDimen2 = { { 1, 2 }, { 3, 4 } };
		System.out.println(Arrays.deepEquals(intTwoDimen2, intTwoDimen1));
	}

	public static void ArrayDeepToString() {
		int[][] twoArr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(Arrays.toString(twoArr));
		System.out.println(Arrays.deepToString(twoArr));
	}

	public static void arrayToString() {
		ArrayList<String> arList = new ArrayList<String>();
		arList.add("abc");
		arList.add("def");
		arList.add("ghi");

		// arList(리스트 형태) 를 배열 형태로
		Object[] objArr = arList.toArray(); // 처음부터 object로 받아서 사용
		String str = Arrays.toString(objArr);
		System.out.println("objArr to String > " + str);

		String[] strArr = new String[arList.size()]; // 먼저 내가 받을 타입으로 설정
		arList.toArray(strArr);
		System.out.println(Arrays.toString(strArr));
	}

}
