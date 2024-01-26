package com.poseidon.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poseidon.dao.LogDAO;
import com.poseidon.dao.MemberDAO;
import com.poseidon.dto.MemberDTO;
import com.poseidon.util.Util;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "";
		if(session.getAttribute("mname")!=null) {
			url="index.jsp";
		} else {
			url="login.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
	} 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("id")!=null&&request.getParameter("pw")!=null) {
			MemberDTO dto = new MemberDTO();
			dto.setMid(request.getParameter("id"));
			dto.setMpw(request.getParameter("pw"));
			
			MemberDAO dao = new MemberDAO();
			dto = dao.login(dto);
			//아이피 저장
			Map<String, Object> log = new HashMap<String, Object>();
			log.put("ip",Util.getIP(request));
			log.put("url", "./login");
			log.put("data", "id:"+dto.getMid()+", pw:"+dto.getMpw()+" 결과:"+dto.getCount());
			
			LogDAO logDAO = new LogDAO();
			logDAO.write(log);
			
			if(dto.getCount()==1) {
				System.out.println("정상 로그인");
				
//				세션 만들기-세션 스코프(외우기)
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
		} 
			
	}

}
