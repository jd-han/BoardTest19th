package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardCommentVO;
import board.BoardDAO;

@WebServlet("/updateComment")
public class UpdateCommentController extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardCommentVO comment = new BoardCommentVO();
		comment.setCommentNo(Integer.parseInt(request.getParameter("commentNo")));
		comment.setNo(Integer.parseInt(request.getParameter("no")));
		comment.setContent(request.getParameter("content"));
		
		new BoardDAO().updateBoardComment(comment);
		
		response.sendRedirect(request.getContextPath()+"/detail?no=" + comment.getNo());
	}

}
