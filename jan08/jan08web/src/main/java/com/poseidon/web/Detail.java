package com.poseidon.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poseidon.dao.BoardDAO;
import com.poseidon.dao.CommentDAO;
import com.poseidon.dao.LogDAO;
import com.poseidon.dto.BoardDTO;
import com.poseidon.dto.CommentDTO;
import com.poseidon.util.Util;

@WebServlet("/detail")
public class Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Detail() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());

//  	오는 db 잡기s
		int no = Util.str2Int(request.getParameter("no"));
//  	db에 질의하기
		BoardDAO dao = new BoardDAO();
		
		//log
		dao.logWrite(Util.getIP(request), getServletName(), "board_no="+no);
		
		
//		로그인 한 회원이라면 조회수 올리기
		HttpSession session = request.getSession();

		if (session.getAttribute("mid") != null) {
//		bno, mno 필요
			dao.countUp(no, (String) session.getAttribute("mid"));
		}
		
		BoardDTO dto = dao.detail(no);
//		String ip2 = ip.substring(ip.indexOf(".",1));
		dto.setIp(Util.ipChange(dto.getIp()));
		
//  내용 가져오기
		if (no == 0 || dto.getContent() == null) {
			response.sendRedirect("error.jsp");
		} else {
//				내용 가져오기
			request.setAttribute("detail", dto);

//				댓글이 있다면 LIST 뽑아내기
			CommentDAO cDao = new CommentDAO();
			List<CommentDTO> commentList = cDao.commentList(dto.getNo());

			if (commentList.size() > 0) {
				request.setAttribute("commentList", commentList);
			}

			// requestDispacher 호출
			RequestDispatcher rd = request.getRequestDispatcher("detail.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
