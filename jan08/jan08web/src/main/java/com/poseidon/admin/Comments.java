package com.poseidon.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poseidon.dao.AdminDAO;
import com.poseidon.dto.CommentDTO;
import com.poseidon.util.Util;

@WebServlet("/admin/comments")
public class Comments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Comments() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminDAO dao = new AdminDAO();
		List<CommentDTO> list = new ArrayList<CommentDTO>();
		if(request.getParameter("del")!=null&&request.getParameter("del")!="") {
			list = dao.commentList(request.getParameter("del"));
		} else {
			list = dao.commentList();
		}
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/comments.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
