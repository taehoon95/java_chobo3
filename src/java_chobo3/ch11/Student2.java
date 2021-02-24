package java_chobo3.ch11;

import java.util.Comparator;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

public class Student2 /* implements  Comparable */ {
	String name;
	int ban;
	int no;
	int kor, eng, math;

	public Student2(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public Student2(String name, int ban, int no) {
		this.name = name;
		this.ban = ban;
		this.no = no;
	}

	public Student2(String name, int ban) {
		this.name = name;
		this.ban = ban;
	}

	@Override
	public String toString() {
		return String.format("Student [name=%s, ban=%s, no=%s, kor=%s, eng=%s, math=%s]", name, ban, no, kor, eng,
				math);
	}

	



//	@Override
//	public int compareTo(Object o) {
//		if(o instanceof Student2) {
//			Student2 tmp = (Student2)o;
//			return name.compareTo(tmp.name);
//		}else {
//			return -1;
//		}
//		
//	}
}
