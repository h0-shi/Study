package com.poseidon.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Logout() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("get으로 진입");
		//세션 종료
		
		//로그인 페이지로 이동
		HttpSession session = request.getSession();
		if(session.getAttribute("mname")!=null) {
			System.out.println("세션 유효시간 : "+session.getMaxInactiveInterval());
			System.out.println("mname : "+session.getAttribute("mname"));
			session.removeAttribute("mname");
		}
		if(session.getAttribute("mid")!=null){
			System.out.println("mid : "+session.getAttribute("mid"));
			session.removeAttribute("mid");
		}
		
		session.invalidate();
		// invalidate()는 세션 자체를 무효화 및 제거하고
		// removeAttribute는 는 현재 세션에서 특정 key-Value만 제거한다.
		// removeAttribute로 현재 키만 제거하면 httpSession 인턴스가 남아있어
		//invalidate로 해주는것이 좋다.
		
//		response.sendRedirect("./logout");
		RequestDispatcher rd = request.getRequestDispatcher("logout.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		System.out.println("post로 진입");
	}

}
