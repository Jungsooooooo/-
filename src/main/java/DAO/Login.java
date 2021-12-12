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
		// TODO Auto-generated method stub
		
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
		}
	}

}
