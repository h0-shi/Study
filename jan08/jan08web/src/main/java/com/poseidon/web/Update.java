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

@WebServlet("/update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Update() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			
		int no = Util.str2Int(request.getParameter("no"));
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.detail(no);
		request.setAttribute("update", dto);
		if(no == 0||dto.getContent()==null) {
			response.sendRedirect("error.jsp");
		} else {
			//  requestDispacher 호출
			RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String no = request.getParameter("no");
		
		if(title!=null&&content!=null&&Util.intCheck(no)) {
//			수정
			BoardDTO dto = new BoardDTO();
			dto.setTitle(title);
			dto.setContent(content);
			dto.setNo(Util.str2Int(no));

			BoardDAO dao = new BoardDAO();
			dao.update(dto);
			response.sendRedirect("./detail?no="+no);
		} else {
//			에러로 이동
			response.sendRedirect("./error.jsp");
		}
		
	}

}
