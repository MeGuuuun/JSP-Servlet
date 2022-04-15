package com.terry.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/add") //어노테이션을 활용한 mapping
public class add extends HttpServlet {
	
	//request :클라이언트로부터 입력받은 값, response : 서버가 클라이언트로 다시 내보내는 값 
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		resp.setCharacterEncoding("UTF-8"); //한글 출력
		resp.setContentType("text/html; charset=UTF-8"); //response header에 컨텐트 타입에 대한 설명 추가 
		
		PrintWriter out = resp.getWriter();
		
		int x = Integer.parseInt(req.getParameter("x"));
		int y = Integer.parseInt(req.getParameter("y"));
		int sum = x+y;
		//.getParameter 사용자의 입력값을 읽어오는 메소드 
		
		out.print(sum);
	}

}
