package java_chobo3.ch16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class URLConnectionEx {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("https://sports.news.naver.com/news.nhn?oid=398&aid=0000044289");
		
		try(BufferedReader br = new BufferedReader(
				new InputStreamReader(url.openStream()));
				BufferedWriter bw = new BufferedWriter(
						new OutputStreamWriter(
								new FileOutputStream("test.html")))){
			String line = null;
			
			while((line = br.readLine()) != null) { //한줄씩읽어서 line에 담는다.
				System.out.println(line);
				bw.write(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
