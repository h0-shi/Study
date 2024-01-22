package com.poseidon.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poseidon.dao.CommentDAO;
import com.poseidon.dto.CommentDTO;
import com.poseidon.util.Util;

@WebServlet("/commentDel")
public class CommentDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CommentDel() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		System.out.println(request.getParameter("cno"));
		System.out.println(request.getParameter("no"));
		if(session.getAttribute("mid")!=null&&request.getParameter("no")!=null) {
			CommentDTO dto = new CommentDTO();
			dto.setMid((String) session.getAttribute("mid"));
			dto.setCno(Util.str2Int(request.getParameter("cno")));
			dto.setBoard_no(Util.str2Int(request.getParameter("no")));
			
			CommentDAO dao = new CommentDAO();
			int result = dao.commentDelete(dto);
			if(result==1) {
				response.sendRedirect("./detail?no="+dto.getBoard_no());
			}else {
				System.out.println("DAO 오류");
				response.sendRedirect("./error.jsp");
			}
			
			
		} else {
			System.out.println("세션 오류");
			response.sendRedirect("./error.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
