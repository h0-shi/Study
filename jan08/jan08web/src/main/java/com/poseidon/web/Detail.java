package com.poseidon.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poseidon.dao.BoardDAO;
import com.poseidon.dto.BoardDTO;
import com.poseidon.util.Util;

@WebServlet("/detail")
public class Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Detail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());

//  	오는 db 잡기s
//		int no = Integer.parseInt(request.getParameter("no"));
		int no = Util.str2Int(request.getParameter("no"));
//  db에 질의하기
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.detail(no);
		
//		System.out.println(dto.getTitle());
//		System.out.println(dto.getContent()==null);
//  내용 가져오기
		request.setAttribute("detail", dto);
		if(no == 0||dto.getContent()==null) {
			response.sendRedirect("error.jsp");
		} else {
//  requestDispacher 호출
			RequestDispatcher rd = request.getRequestDispatcher("detail.jsp");
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
