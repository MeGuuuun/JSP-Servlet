package com.terry.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/notice-reg") //어노테이션을 활용한 mapping
public class notice_reg extends HttpServlet {
	
	//request :클라이언트로부터 입력받은 값, response : 서버가 클라이언트로 다시 내보내는 값 
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		resp.setCharacterEncoding("UTF-8"); //한글 출력
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8"); //response header에 컨텐트 타입에 대한 설명 추가 
		
		PrintWriter out = resp.getWriter();
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		//.getParameter 사용자의 입력값을 읽어오는 메소드 
		
		out.print(title);
		out.print(content);
	}

}
