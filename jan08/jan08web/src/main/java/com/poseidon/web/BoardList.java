package com.poseidon.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poseidon.dao.BoardDAO;
import com.poseidon.dao.LogDAO;
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

		//아이피 저장_map 사용
		Map<String, Object> log = new HashMap<String, Object>();
		System.out.println(Util.getIP(request));
		
		log.put("ip",Util.getIP(request));
		log.put("url", "./board");
		log.put("data", "page="+request.getParameter("page"));
		
		LogDAO logDAO = new LogDAO();
		logDAO.write(log);
		
		
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> list = dao.boardList(page);
		int totalCount = dao.totalCount();

		request.setAttribute("totalCount", totalCount);
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		
		RequestDispatcher rd = request.getRequestDispatcher("board.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
	}

}
