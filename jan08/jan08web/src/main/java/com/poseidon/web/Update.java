package com.poseidon.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poseidon.dao.BoardDAO;
import com.poseidon.dto.BoardDTO;
import com.poseidon.util.Util;

@WebServlet("/update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Update() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String mid = request.getParameter("mid");
		if (session.getAttribute("mid") != null) {
			int no = Util.str2Int(request.getParameter("no"));
			BoardDAO dao = new BoardDAO();
			BoardDTO dto = dao.detail(no);
//	         System.out.println(dto.getMid().equals(session.getAttribute("mid")));
//	         System.out.println(session.getAttribute("mid").equals(dto.getMid()));
//	         System.out.println(session.getAttribute("mid") == dto.getMid());
//	         System.out.println(((String)session.getAttribute("mid")).equals(dto.getMid()));
			request.setAttribute("update", dto);
			if (dto.getMid().equals(session.getAttribute(mid))) {
				System.out.println("정보 불일치");
				response.sendRedirect("error.jsp");
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
				rd.forward(request, response);
			}

		} else {
			response.sendRedirect("./login?login=nologin");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String no = request.getParameter("no");
		String mid = request.getParameter("mid");

		if (title != null && content != null 
				&& Util.intCheck(no)&&session.getAttribute("mid")!=null) {
//			수정
			BoardDTO dto = new BoardDTO();
			dto.setTitle(title);
			dto.setContent(content);
			dto.setNo(Util.str2Int(no));
			dto.setMid(mid);

			BoardDAO dao = new BoardDAO();
			dao.update(dto);
			response.sendRedirect("./detail?no=" + no);
		} else {
//			에러로 이동
			response.sendRedirect("./error.jsp");
			System.out.println("작성 오류");
		}

	}

}
