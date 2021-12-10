package DAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import DTO.PhoneDTO;

/**
 * Servlet implementation class main
 */
@WebServlet("/main")
public class main extends HttpServlet {
	private static final long serialVersionUID = 1L;
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.sendRedirect("main.jsp");
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String name = request.getParameter("name");
		String birth= request.getParameter("birth");
		String phoneNum = request.getParameter("phoneNum");
		
		
		
		String filepath = "C:\\javaexercise\\PhoneBookServlet\\src\\main\\webapp/phoneBook.txt";
		
		try {
			FileReader fr = new FileReader(filepath);
		BufferedReader br = new BufferedReader(fr);
		
		String line= "";
		
		ArrayList<PhoneDTO>arrayList = new ArrayList<>(); // arrayList 하나 만들어 주고
		
		for(int i=1;(line=br.readLine())!=null;i++) {	// txt파일에 있는 내용 line 별로 읽어오는 기능
			if(line.indexOf("")!=-1) {					// 안에 내용이 ("")문자열이 있으면
				
				String[] pdtoarr = line.split(",");
				PhoneDTO pdto = new PhoneDTO(pdtoarr[0], pdtoarr[1],pdtoarr[2]);
				
				arrayList.add(pdto);					// 더해준다.
				
			} 
				
		}
			if(name!=""&&birth!=""&&phoneNum!="") {
			arrayList.add(new PhoneDTO(name,birth,phoneNum));
			}

			br.close();
		
		
		//객체를 다시 스트링으로 바꿔 줘야 한다.
		PrintWriter pw = new PrintWriter(filepath);
		for(int i = 0; i<arrayList.size(); i++) {
		
			pw.println(arrayList.get(i));
			
		}
			pw.close();
			
			response.sendRedirect("main.jsp");
		
	}catch(IOException e) {
		e.printStackTrace();
	}

	}
		
		
		

}
