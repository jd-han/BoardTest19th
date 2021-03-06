package board.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import board.BoardDAO;
import board.BoardFileVO;
import board.BoardVO;
import util.BitFileRenamePolicy;

@WebServlet("/write")
public class WriteController extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("/upload");

		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
		String datePath = sdf.format(new Date());
		
		String savePath = path + datePath;
		File f = new File(savePath);
		if (!f.exists()) f.mkdirs();
		
		// 파일 처리를 위한 API 클래스 호출
		MultipartRequest mRequest = new MultipartRequest(
				request, 
				savePath, 
				1024 * 1024 * 10, 
				"UTF-8",
				new BitFileRenamePolicy()
		);
		
		BoardVO board = new BoardVO();
		board.setTitle(mRequest.getParameter("title"));
		board.setWriter(mRequest.getParameter("writer"));
		board.setContent(mRequest.getParameter("content"));
		
		// 게시물 저장 처리 부탁..
		BoardDAO dao = new BoardDAO();
		int no = dao.insertBoard(board);
		
		File file = mRequest.getFile("attachFile");
		if (file != null) {
			String oriFileName = mRequest.getOriginalFileName("attachFile");
			String realFileName = mRequest.getFilesystemName("attachFile");
			long fileSize = file.length();
			
			BoardFileVO boardFile = new BoardFileVO();
			boardFile.setNo(no);
			boardFile.setOriFileName(oriFileName);
			boardFile.setRealFileName(realFileName);
			boardFile.setFilePath(datePath);
			boardFile.setFileSize(fileSize);
			
			dao.insertBoardFile(boardFile);
		}
		
		response.sendRedirect(request.getContextPath()+"/list");
	}

}
