package DAO;


import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import DTO.PhoneDTO;


// Text 파일에 출력해보기
public class FileWriterMain {

	public static void main(String[] args)  {
		
		String filePath="C:\\javaexercise\\PhoneBookServlet\\src\\main\\webapp/phoneBook.txt";
		
		try {
		//FileWriter fw = new FileWriter(""); // 파일 경로 지정
				
		
		PrintWriter pw = new PrintWriter(filePath);
			
			for(int i = 0; i < 9 ; i++) {
				pw.println(new PhoneDTO("김정수"+i , "93050"+i ,"0101234123"+i));
			}
				
				pw.close();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
