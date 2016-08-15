package board;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

import util.MyAppSqlConfig;

public class BoardDAO {
	private static SqlSession session;
	
	public BoardDAO() {
		session = MyAppSqlConfig.getSqlSessionInstance();
	}
	
	// 전체 글 조회
	public List<BoardVO> selectBoard() {
		List<BoardVO> list = session.selectList("board.BoardDAO.selectAllBoard");
		return list;
	}
	
	// 글 번호로 조회
	public BoardVO selectBoardByNo(int findNo) {
		BoardVO board = session.selectOne("board.BoardDAO.selectBoardByNo", findNo);
		return board;
	}
	
	// 글 등록
	public int insertBoard(BoardVO board) {
		session.insert("board.BoardDAO.insertBoard", board);
		session.commit();
		return board.getNo();
	}
	
	// 글 수정
	public int updateBoard(BoardVO board) {
		session.update("board.BoardDAO.updateBoard", board);
		session.commit();
		return 1;
	}
	
	// 글 삭제
	public int deleteBoard(int delNo) {
		session.delete("board.BoardDAO.deleteBoard", delNo);
		session.commit();
		return 1;
	}
	
	// 파일 등록
	public void insertBoardFile(BoardFileVO boardFile) {
		session.insert("board.BoardDAO.insertBoardFile", boardFile);
		session.commit();
	}
	
	// 글 번호로 파일 조회
	public BoardFileVO selectBoardFileByNo(int findNo) {
		return session.selectOne(
				"board.BoardDAO.selectBoardFileByNo", findNo);
	}

	// 댓글 등록
	public void insertBoardComment(BoardCommentVO comment) {
		session.insert("board.BoardDAO.insertBoardComment", comment);
		session.commit(); 
	}
	
	// 글 번호로 댓글 조회
	public List<BoardCommentVO> selectBoardCommentByNo(int findNo) {
		return session.selectList(
				"board.BoardDAO.selectBoardCommentByNo", findNo);
	}

	// 댓글 삭제
	public void deleteBoardComment(int commentNo) {
		session.delete("board.BoardDAO.deleteBoardComment", commentNo);
		session.commit();
	}
	
	// 댓글 번호로 댓글 조회
	public BoardCommentVO selectBoardCommentByCommentNo(int commentNo) {
		return session.selectOne(
				"board.BoardDAO.selectBoardCommentByCommentNo", commentNo);
	}

	// 댓글 수정
	public void updateBoardComment(BoardCommentVO comment) {
		session.update("board.BoardDAO.updateBoardComment", comment);
		session.commit();
	}
	
}
