package DAO;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		
			out.println("<body>");
				out.println("<form method='post' action='Login'>");
				out.println("<div>");
				out.println("아이디"+"<input type='text' name='id'/>");
				out.println("</div>");
				out.println("<div>");
				out.println("비밀번호"+"<input type='password' name='password'/>");
				out.println("</div>");
				out.println("<div>");
				out.println("<input type='submit' value='로그인'/>");
				out.println("</div>");
				out.println("</form>");
			out.println("</body>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		
		PrintWriter out = response.getWriter();
		
		String id 		= request.getParameter("id");
		String password	= request.getParameter("password");
		HttpSession session = request.getSession();
		
		if(id.equals("김정수") && password.equals("1234") ) {
			session.setAttribute("jungsoo",id);
			out.println("<script>");
			out.println("alert('로그인 되었습니다')");
			out.println("</script>");
			out.println("<body>");
			out.println(id+"님 환영합니다");
			out.println("<a href=main.jsp>");
			out.println("<br>"+"전화번호부로이동");
			out.println("</body>");
		} else {
			out.println("<script>");
			out.println("alert('아이디와 비밀번호를 다시 확인해주세요.')");
			out.println("location.href ='Login' ");
			out.println("</script>");
		}
	}

}
