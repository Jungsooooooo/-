<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%@page import="java.util.ArrayList" %>
<%@page import="DTO.PhoneDTO" %>
	
		
		
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전화번호부</title>
</head>
<body>
	<form action="main" method="post">
			<div>
				이름<input type="text" name="name"/>
			</div>
			<div>	
				생년월일<input type="text" name="birth"/>
			</div>	
			<div>	
				전화번호<input type="text" name="phoneNum"/>
			</div>
			<div>	
				<input type="submit" value="저장하기"/>
			</div>
		</form>	
		
		
		<%
		String filepath = "C:\\javaexercise\\PhoneBookServlet\\src\\main\\webapp/phoneBook.txt";

		try {
			FileReader fr = new FileReader(filepath);
		BufferedReader br = new BufferedReader(fr);
		
		String line= "";
		
		ArrayList<PhoneDTO>arrayList = new ArrayList<>(); // arrayList 하나 만들어 주고
		
		for(int i=0;(line=br.readLine())!=null;i++) {	// txt파일에 있는 내용 line 별로 읽어오는 기능
			if(line.indexOf("")!=-1) {					// 안에 내용이 ("")문자열이 있으면
				
				String[] pdtoarr = line.split(",");
				PhoneDTO pdto = new PhoneDTO(pdtoarr[0], pdtoarr[1],pdtoarr[2]);
				
				arrayList.add(pdto);					// 더해준다.
				//out.println(arrayList.get(i)+"<br>");
			} 
		}
		
	%>
		
		<h4>전체리스트</h4>
		<ul>
		<%
			for(int i = 0; i<arrayList.size();i++){
		out.print("<li>"+"이름: "+arrayList.get(i).getName()+", "
					+"생년월일: "+arrayList.get(i).getBirth()+", "
					+"전화번호:" +arrayList.get(i).getPhoneNum()+"<br>"+"</li>")
		;} %>
		</ul>
		
		<% 
				br.close();
			
		
	}catch(IOException e) {
		e.printStackTrace();
	}
		%>
</body>
</html>