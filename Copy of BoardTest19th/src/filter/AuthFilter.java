package filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberVO;

public class AuthFilter implements Filter {
	
	private List<String> pageList;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String values = filterConfig.getInitParameter("pages");
		String[] pageArr = values.split(";");
		// 로그인 없이 사용할 페이지 정보를 리스트에 추가
		pageList = new ArrayList<>();
		for (String p : pageArr) {
			pageList.add(p.trim());
		}
//		System.out.println(pageList);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// pageList에 호출한 페이지가 존재할 경우, 다음 페이지로 이동시킴
		// pageList에 호출한 페이지가 존재하지 않을 경우, 세션에 user정보가 등록되어 있는지 확인
		// user 정보가 등록되지 않은 경우 loginForm 페이지로 이동시킴
		// user 정보가 등록되어 있는 경우 다음 페이지로 이동시킴
		HttpServletRequest hRequest = (HttpServletRequest)request;
		HttpServletResponse hResponse = (HttpServletResponse)response;
		
		String requestUri = hRequest.getRequestURI();
//		System.out.println("사용자 호출 페이지 정보");
//		System.out.println(requestUri);
		
//		 	   ↓/MyBoard
		String contextPath = hRequest.getContextPath();
		requestUri = requestUri.substring(contextPath.length());
		System.out.println(requestUri);
		
		boolean isRedirect = false;
		int index = pageList.indexOf(requestUri);
		if (index == -1) {
//			System.out.println("리스트에 ㄴㄴ 페이지");
			HttpSession session = hRequest.getSession();
			MemberVO user = (MemberVO)session.getAttribute("LOGIN_USER");
			
			if (user == null) {
				isRedirect = true;
			}
		}
		
		if (isRedirect) {
			hResponse.sendRedirect(hRequest.getContextPath() + "/loginForm");
		} else {
			chain.doFilter(request, response);
		}
		
//		주소 걍 한번에...
//		String path = hRequest.getServletPath();
//		System.out.println(path);
	}

	@Override
	public void destroy() {}
	
}

