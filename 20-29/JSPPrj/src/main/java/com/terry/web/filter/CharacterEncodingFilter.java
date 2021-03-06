package com.terry.web.filter;

//filter interface 
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*") //어노테이션으로 매핑 
public class CharacterEncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		req.setCharacterEncoding("UTF-8");//모든 필터 거치는 서블릿의 인코딩 작업이 됨 
		//before filter
		chain.doFilter(req, resp); // reg와 resp를 받아 다음 흐름으로 넘겨줌 -> 다음 서블릿이 실행하도록 한 뒤 결과를 받음.
		//after filter
	}

}
