package com.terry.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

//Application 저장소 활용 
@WebServlet("/calc") //어노테이션을 활용한 mapping
public class calc extends HttpServlet {
	
	//request :클라이언트로부터 입력받은 값, response : 서버가 클라이언트로 다시 내보내는 값 
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		resp.setCharacterEncoding("UTF-8"); //한글 출력
		resp.setContentType("text/html; charset=UTF-8"); //response header에 컨텐트 타입에 대한 설명 추가 
		
		//어플리케이션 저장소 
		ServletContext application = req.getServletContext();
		//Session 
		HttpSession session = req.getSession();
		
		String v_ = req.getParameter("v"); //사용자가 입력한 값 
		String op = req.getParameter("operator"); //사용자가 클릭한 연산기호 
		
		int v = 0; //사용자가 값을 입력하지 않았을 경우 고려 
		if(!v_.equals("")) v = Integer.parseInt(v_); 
		
		//calculate
		if(op.equals("=")) {
			
			//int x = (Integer)application.getAttribute("value"); //저장소에 저장된 값 불러오기 , 오브젝트이므로 정수형 변환 
			int x = (Integer)session.getAttribute("value");
			int y = v;
			
			//String operator = (String)application.getAttribute("op");
			String operator = (String)session.getAttribute("op");
			int result = 0;
			
			if(operator.equals("+"))
				result = x+y;
			else
				result = x-y;
			
			resp.getWriter().printf("result is %d\n", result);
		}
		//save data 
		else {
			//application.setAttribute("value", v); //자바 map과 같은 형식 
			//application.setAttribute("op", op);
			
			session.setAttribute("value", v); 
			session.setAttribute("op", op);
		}
		//application과 session의 차이점
		//session은 현재 접속한 사용자 한정 - 사용자별로 개별적인 공간을 부여받음
		//브라우저가 다르면 각자 다른 사용자로 인식 -> 다른 브라우저로 값이 넘어가지 않음 
	}

}
