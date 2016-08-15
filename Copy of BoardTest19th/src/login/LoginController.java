package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import member.MemberVO;

@WebServlet("/login")
public class LoginController extends HttpServlet {
//		if (m.getId() == null) {
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputId = request.getParameter("id");
		String inputPass = request.getParameter("pass");
		
		MemberDAO dao = new MemberDAO();
		MemberVO m = dao.selectMemberById(inputId);
		
		
		
		if (m == null) {
			response.sendRedirect(request.getContextPath()+"/loginForm");
		}
		
		if (m.getId().equals(inputId) && m.getPass().equals(inputPass)) {
			HttpSession session = request.getSession();
			session.setAttribute("LOGIN_USER", m);
			response.sendRedirect(request.getContextPath()+"/index");
		} else {
			response.sendRedirect(request.getContextPath()+"/loginForm");
		}
		
	}

}
