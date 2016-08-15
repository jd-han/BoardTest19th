package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardCommentVO;
import board.BoardDAO;
import board.BoardFileVO;
import board.BoardVO;

@WebServlet("/detail")
public class DetailController extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int findNo = Integer.parseInt(request.getParameter("no"));
		BoardDAO dao = new BoardDAO();
		BoardVO board = dao.selectBoardByNo(findNo);
		
		// 게시물과 연관된 파일 정보 추출
		BoardFileVO file = dao.selectBoardFileByNo(findNo);
		
		List<BoardCommentVO> commentList = dao.selectBoardCommentByNo(findNo);
		
		request.setAttribute("board", board);
		// 파일 정보 공유
		request.setAttribute("file", file);
		
		request.setAttribute("commentList", commentList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/detail.jsp?no=" + board.getNo());
		rd.forward(request, response);
	}
	
}
