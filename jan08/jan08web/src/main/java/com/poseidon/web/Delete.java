package com.poseidon.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poseidon.dao.BoardDAO;
import com.poseidon.dto.BoardDTO;
import com.poseidon.util.Util;

@WebServlet("/delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Delete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
//  	오는 db 잡기
//			숫자네?삭제 진행-> 보드로 이동
//			번호 받기
			int no = Util.str2Int(request.getParameter("no"));
			
			if(Util.intCheck(request.getParameter("no")) && session.getAttribute("mid") != null) {
//			DAO 일 시키기
				BoardDAO dao = new BoardDAO();
				BoardDTO dto = new BoardDTO();
				dto.setNo(no);
				dto.setMid((String)session.getAttribute("mid"));
				int result = dao.delete(dto);
//			잘 삭제되었는지 값 받기
				System.out.println("삭제여부 : "+result);
				
				if(result == 1) {
//				RequestDispatcher rd = request.getRequestDispatcher("delete.jsp");
//				rd.forward(request, response);
					response.sendRedirect("./board");
				} else {
					response.sendRedirect("./error.jsp");
					System.out.println("reuslt 에러");
				}
			} else {
				System.out.println("작성자 아님");
				response.sendRedirect("./error.jsp");
			}
			
//			숫자가 아니네? => 에러 표시
//		int no = Integer.parseInt(request.getParameter("no"));
//  db에 질의하기
//  내용 가져오기
//  requestDispacher 호출
 
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
