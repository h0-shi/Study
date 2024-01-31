package com.poseidon.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poseidon.dao.AdminDAO;

@WebServlet("/admin/ip")
public class Ip extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ip() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminDAO dao = new AdminDAO();
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		if(request.getParameter("distinct")!=null) {
			System.out.println("중복없이 실행");
			list = dao.distinictIp();
		} else if(request.getParameter("iip")!=null&&request.getParameter("iip")!=""){
			System.out.println("iip 실행");
			list = dao.ipList(request.getParameter("iip"));
		} else {
			list = dao.ipList();
		}
		
		List<Map<String, Object>> ipTop  = dao.ipTop();
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("ip.jsp");
		request.setAttribute("ipTop", ipTop);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
