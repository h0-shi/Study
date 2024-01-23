package com.poseidon.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poseidon.dao.BoardDAO;
import com.poseidon.dao.MemberDAO;
import com.poseidon.dto.MemberDTO;
import com.poseidon.dto.VisitCountDTO;

/**
 * Servlet implementation class Info
 */
@WebServlet("/myInfo")
public class myInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public myInfo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("mid")!=null) {
//			mid를 db에 질의
			MemberDTO dto = new MemberDTO();
			MemberDAO dao = new MemberDAO();
			BoardDAO bDao = new BoardDAO();
			
//			DTO에 담아서
//			dto에 mid를 담아서 dao를 돌린다.
			dto.setMid((String) session.getAttribute("mid"));
			
			List<Map<String, Object>> readData = bDao.readData(dto);
			dto = dao.myInfo(dto);
			
//			myInfo에 찍자 - 값 넘기기
			request.setAttribute("myInfo", dto);
			request.setAttribute("readData", readData);
			
			RequestDispatcher rd = request.getRequestDispatcher("myInfo.jsp");
			rd.forward(request, response);
			
		} else {
			response.sendRedirect("./login");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String newPw = request.getParameter("newPw");
		String mid = request.getParameter("mid");
		System.out.println(newPw);
		System.out.println(mid);
		MemberDTO dto = new MemberDTO();
		MemberDAO dao = new MemberDAO();
		dto.setMid(mid);
		dto.setMpw(newPw);
		dao.alterPw(dto);
	
		response.sendRedirect("./myInfo");
	}

}
