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

@WebServlet("/comment")
public class Comment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Comment() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글처리
		request.setCharacterEncoding("UTF-8");
		//오는 값 받기
		HttpSession session = request.getSession();
		
		
		if(session.getAttribute("mid")!=null && session.getAttribute("mname")!=null) {
			String commentcontent = request.getParameter("commentcontent");
			String bno = request.getParameter("bno");
			//특수기호 제거 <,> 변경하기
			commentcontent = Util.removeTag(commentcontent);

			//줄바꿈 처리하기 \r \n \nr =rn
			commentcontent = Util.addBR(commentcontent);
			
			if(commentcontent!=null&&bno != null) {
				CommentDTO dto = new CommentDTO();
				dto.setBoard_no(Util.str2Int(bno));
				dto.setMid((String) session.getAttribute("mid"));
				dto.setIp(Util.getIP(request));
				
				//저장
				dto.setComment(commentcontent);
				CommentDAO dao = new CommentDAO();
				int result = dao.commentWrite(dto);
//				dao.logWrite(Util.getIP(request), getServletName(),"bno:"+bno+", 내용:"+dto.getComment());

				
				if(result == 1) {
					//이동
					response.sendRedirect("./detail?no="+bno);
				} else {
					System.out.println("DAO작동 오류");
					response.sendRedirect("./error.jsp");
				}
			}
			
		} else {
			System.out.println("세션 없음");
			response.sendRedirect("./login.jsp");
		}
		
	}

}
