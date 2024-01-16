package com.poseidon.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poseidon.dao.BoardDAO;
import com.poseidon.dto.BoardDTO;
import com.poseidon.util.Util;

@WebServlet("/board")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//DAO랑 연결
		int page = 1;  
		if(request.getParameter("page")!=null) {
			page = Util.str2Int2(request.getParameter("page"));
		}
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> list = dao.boardList(page);

		int totalCount = dao.totalCount();

		request.setAttribute("totalCount", totalCount);
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("board.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
	}

}
