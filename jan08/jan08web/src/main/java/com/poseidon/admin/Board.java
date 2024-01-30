package com.poseidon.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poseidon.dao.AdminDAO;
import com.poseidon.dto.BoardDTO;
import com.poseidon.util.Util;

/**
 * Servlet implementation class AdminBoard
 */
@WebServlet("/admin/board")
public class Board extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Board() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminDAO dao = new AdminDAO();
		List<BoardDTO> list = null;
		if(request.getParameter("search")==null||request.getParameter("search")=="") {
			list = dao.boardList();
		} else {
			list = dao.boardList(request.getParameter("search"));
		}
		int totalCount = dao.totalCount();
		
		request.setAttribute("list", list);
		request.setAttribute("totalCount", totalCount);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/board.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("bno : "+request.getParameter("bno"));
		System.out.println("del : "+request.getParameter("del"));
		AdminDAO dao = new AdminDAO();
		BoardDTO dto = new BoardDTO();
		dto.setNo(Util.str2Int(request.getParameter("bno")));
		dto.setDelete(Util.str2Int2(request.getParameter("del"))==0?1:0);
		int result = dao.boardDel(dto);
		
		PrintWriter pw = response.getWriter();
		pw.print(result);
	}

}
