package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardVO;

@WebServlet("/updateForm")
public class UpdateFormController extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO board = new BoardDAO().selectBoardByNo(Integer.parseInt(request.getParameter("no")));
		
		request.setAttribute("board", board);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/updateForm.jsp?no=" + board.getNo());
		rd.forward(request, response);
	}

}
