package java_chobo3.ch15;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamEx {
	public static void main(String[] args) throws FileNotFoundException, IOException {
//		fileInputStreamEx();
		fileBufferdInputStream();
		
	}

	public static void fileBufferdInputStream() throws IOException, FileNotFoundException {
		File file = new File("mysql-connector-java-5.1.49.jar"); 
		try(FileInputStream fis = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fis, 8192);
				FileOutputStream fos = new FileOutputStream("mysql_lib.jar");
				BufferedOutputStream bos = new BufferedOutputStream(fos, 8192)){
			int data = 0;
			while( (data = bis.read()) != -1) {
				bos.write(data);
			}
		}
	}

	public static void fileInputStreamEx() {
		try {
			FileInputStream fis = new FileInputStream("image.png");
			FileOutputStream fos = new FileOutputStream("test.png");
			int data = 0;
			while( (data = fis.read()) != -1) {
				fos.write(data);
			}
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
