package java_chobo3.ch10;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Ex10_6 {

	public static void main(String[] args) throws ParseException {
		double a = 12345678.123456;
		DecimalFormat df = new DecimalFormat();
		String st = df.format(a);
		DecimalFormat df2 = new DecimalFormat("000000000,000.0000000");
		System.out.println(st);
		String st2 = df2.format(a);
		System.out.println(st2);
		
		String num = "123,123,123.23";
		DecimalFormat df3 = new DecimalFormat();
		double n = df3.parse(num).doubleValue();
		System.out.println(n);
	}

}
