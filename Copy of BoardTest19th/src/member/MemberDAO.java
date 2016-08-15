package member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import util.MyAppSqlConfig;

public class MemberDAO {
	
	private static SqlSession session;
	
	public MemberDAO() {
		session = MyAppSqlConfig.getSqlSessionInstance();
	}
	
	// 로그인
	public MemberVO selectMemberById(String id) {
		return session.selectOne("member.MemberDAO.selectMemberById", id); 
	}
	
}
