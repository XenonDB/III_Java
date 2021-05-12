package practice.y2021.m5.d6.filedemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class FileDemo {

	public static final File PATH1 = new File("filedemo\\demo.txt");
	public static final File PATH2 = new File("filedemo\\demoout.txt");
	
	public static final String DEMO_WRITECONTENT = "ｓｓｅｅｅｅ88哈囉9ｓｓ4ｄｄｄｄ\n９８９８＊+s３eｙ";
	
	public static final Charset UTF8 = StandardCharsets.UTF_8;
	//public static final Charset MS950 = new sun.nio.cs.MS950();
	
	static {
		PATH2.getParentFile().mkdir();
		try {
			System.out.println(PATH2.createNewFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//fileReadingDemo();
		//fileWriteDemo();
		//fileReaderDemo();
		fileWriterDemo();
	}
	
	public static void fileReadingDemo() {
		//Files.
		File f = PATH1;
		
		f.getParentFile().mkdir();
		try {
			System.out.println(f.createNewFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try(FileInputStream fis = new FileInputStream(f)){
			
			//byte[] buffer = new byte[30];
			StringBuilder result = new StringBuilder();
			/*
			while(fis.read(buffer) >= 0) {
				result.append(new String(buffer,StandardCharsets.UTF_8));
				Arrays.fill(buffer, (byte)0);
				LinkedList<Byte> ls = new LinkedList<>();
				result.
			}
			*/
			System.out.println(new String(fis.readAllBytes(),StandardCharsets.UTF_8));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void fileWriteDemo() {
		try(FileWriter fos = new FileWriter(PATH2)) {
			
			fos.write(DEMO_WRITECONTENT);
			fos.flush();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void fileReaderDemo() {
		
		try(FileReader fr = new FileReader(PATH1, StandardCharsets.UTF_8)) {
			
			char[] buffer = new char[4];
			StringBuilder sb = new StringBuilder();
			
			while(fr.read(buffer) >= 0) {
				sb.append(buffer);
				Arrays.fill(buffer, (char)0);
			}
			
			System.out.println(sb.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void fileWriterDemo() {
		/*
		try {
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(PATH2), StandardCharsets.UTF_8);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
		
		//since 11 ._.
		try(FileWriter fw = new FileWriter(PATH2,StandardCharsets.UTF_8)) {
			
			fw.write(DEMO_WRITECONTENT);
			fw.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
