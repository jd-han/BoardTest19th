package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardCommentVO;
import board.BoardDAO;

@WebServlet("/comment")
public class CommentController extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardCommentVO comment = new BoardCommentVO();
		comment.setNo(Integer.parseInt(request.getParameter("no")));
		comment.setWriter(request.getParameter("writer"));
		comment.setContent(request.getParameter("content"));
		
		BoardDAO dao = new BoardDAO();
		dao.insertBoardComment(comment);
		response.sendRedirect(request.getContextPath()+"/detail?no="+comment.getNo());
	}
	
}