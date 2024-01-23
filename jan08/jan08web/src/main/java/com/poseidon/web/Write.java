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

@WebServlet("/write")
public class Write extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Write() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="";
		HttpSession session = request.getSession();
		if(session.getAttribute("mname")==null) {
			// url까지 변경
			response.sendRedirect("./login");
		} else {
			//화면만 변경(url 고정)
			RequestDispatcher rd = request.getRequestDispatcher("write.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		if문으로 세션이 있는 사람만 로직 실행하도록 변경
		//세션에 있는 mid 가져오기
		HttpSession session = request.getSession();
		if(session.getAttribute("mid")==null||session.getAttribute("mname")==null) {
//			로그인 하지 않았다면
			response.sendRedirect("./login?login=nologin");
		} else {
//			로그인 했다면 로직 수행
			String title = request.getParameter("title");
			title = Util.removeTag(title);
			String content = request.getParameter("content");
			
//			DAO에 write 메서드 만들기
			BoardDTO dto = new BoardDTO();
			dto.setTitle(title);
			dto.setContent(content);
			dto.setIp(Util.getIP(request));
			
//			session .get으로 얻어는건 모두 object화 된다.
			dto.setMid((String)session.getAttribute("mid")); // session에서 mid 가져온다.
			
			BoardDAO dao = new BoardDAO();
			int result = dao.write(dto);
			System.out.println("글쓰기 결과는 : "+result);
			
//		페이지 이동
			if(result==1) {
				response.sendRedirect("./board");
			} else {
				response.sendRedirect("./error.jsp");
			}
		}
		
		
	}

}
