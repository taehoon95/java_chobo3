package java_chobo3.ch16;

import java.net.*;

public class Ex16_3 {
	public static void main(String args[]) {
		getInforURL();
	} // main

	public static void getInforURL() {
		String address = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EB%8F%99%EB%8C%80%EA%B5%AC%EC%97%AD";

		try {
			URL url = new URL(address);
			URLConnection conn = url.openConnection();
			System.out.println("conn.toString():" + conn);
			System.out.println("getAllowUserInteraction():" + conn.getAllowUserInteraction());
			System.out.print("\tgetConnectTimeout():" + conn.getConnectTimeout());
			System.out.println("getContent():" + conn.getContent());
			System.out.println("getContentEncoding():" + conn.getContentEncoding());
			System.out.print("\tgetContentLength():" + conn.getContentLength());
			System.out.println("getContentType():" + conn.getContentType());
			System.out.print("\tgetDate():" + conn.getDate());
			System.out.println("getDefaultAllowUserInteraction():" + conn.getDefaultAllowUserInteraction());
			System.out.println("getDefaultUseCaches():" + conn.getDefaultUseCaches());
			System.out.print("\tgetDoInput():" + conn.getDoInput());
			System.out.println("getDoOutput():" + conn.getDoOutput());
			System.out.print("\tgetExpiration():" + conn.getExpiration());
			System.out.println("getHeaderFields():" + conn.getHeaderFields());
			System.out.println("getIfModifiedSince():" + conn.getIfModifiedSince());
			System.out.print("\tgetLastModified():" + conn.getLastModified());
			System.out.println("getReadTimeout():" + conn.getReadTimeout());
			System.out.println("getURL():" + conn.getURL());
			System.out.println("getUseCaches():" + conn.getUseCaches());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}