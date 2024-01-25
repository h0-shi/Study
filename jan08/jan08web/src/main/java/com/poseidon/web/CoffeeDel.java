package com.poseidon.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poseidon.dao.BeverageDAO;
import com.poseidon.util.Util;

/**
 * Servlet implementation class CoffeeDel
 */
@WebServlet("/coffeeDel")
public class CoffeeDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CoffeeDel() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ip = Util.getIP(request);
		BeverageDAO dao = new BeverageDAO();
		int result = dao.del(ip);
		if(result==1) {
			response.sendRedirect("./coffee");
		} else {
			response.sendRedirect("./coffee");
			System.out.println("ip 존재하지 않음 오류");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
