package com.poseidon.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poseidon.dao.MemberDAO;
import com.poseidon.dto.MemberDTO;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("id")!=null&&request.getParameter("pw")!=null) {
			MemberDTO dto = new MemberDTO();
			dto.setMid(request.getParameter("id"));
			dto.setMpw(request.getParameter("pw"));
			
			MemberDAO dao = new MemberDAO();
			dto = dao.login(dto);
			if(dto.getCount()==1) {
				System.out.println("정상 로그인");
//				세션 만들기
				HttpSession session = request.getSession();
				session.setAttribute("mname", dto.getMname()); // mname이라는 이름으로 세션 만듬
				session.setAttribute("mid", dto.getMid());	// mid라는 이름으로 세션 만듬
//				페이지 이동 to board
				response.sendRedirect("./board");
			} else {
//				System.out.println("헬로우 사만다");
//				페이지 이동 = login?error=4567
				response.sendRedirect("./login?error=?");
				
			}
			
		} else {
			
		}
			
	}

}
