package java_chobo3.ch11;

import java.util.Comparator;

public class BanNoAsending implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Student2 && o2 instanceof Student2) {
			Student2 tmp1 = (Student2)o1; 
			Student2 tmp2 = (Student2)o2;
			if (tmp1.ban != tmp2.ban) {
				return tmp1.ban - tmp2.ban;
			} else {
				return tmp1.no - tmp2.no;
			}
		}
		return 0;
	}

}
