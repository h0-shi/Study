package com.poseidon.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poseidon.dao.BeverageDAO;
import com.poseidon.dto.BeverageDTO;
import com.poseidon.util.Util;

@WebServlet("/coffee")
public class Coffee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Coffee() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BeverageDAO dao = new BeverageDAO();
		List<BeverageDTO> clist = dao.cList();
		List<BeverageDTO> blist = dao.bList();
		List<BeverageDTO> tlist = dao.tList();

		List<BeverageDTO> hot = dao.hot();
		List<BeverageDTO> ice = dao.ice();
		
		
		request.setAttribute("clist", clist);
		request.setAttribute("blist", blist);
		request.setAttribute("tlist", tlist);
		
		request.setAttribute("hot", hot);
		request.setAttribute("ice", ice);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("coffee.jsp");
		
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("요청 들어옴");
		System.out.println(request.getParameter("beverage"));
		System.out.println(request.getParameter("temp"));
		
		BeverageDTO dto = new BeverageDTO();
		BeverageDAO dao = new BeverageDAO();
		dto.setBeverage(request.getParameter("beverage"));
		dto.setTemp(request.getParameter("temp"));
		dto.setIp(Util.getIP(request));
		
		int result = dao.check(dto);
	
		PrintWriter pw = response.getWriter();
		pw.print(result);
		
	}

}
