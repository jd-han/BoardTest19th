package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;

@WebServlet("/deleteComment")
public class DeleteCommentController extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		dao.deleteBoardComment(Integer.parseInt(request.getParameter("commentNo")));
		
		int no = Integer.parseInt(request.getParameter("no"));
		response.sendRedirect(request.getContextPath()+"/detail?no=" + no);
	}
}
