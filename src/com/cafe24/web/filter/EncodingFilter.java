package com.cafe24.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@WebFilter("/*")
public class EncodingFilter implements Filter {
	private String encoding;

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Encdoing Filter Initialized...");

		encoding = fConfig.getInitParameter("");
		if (encoding == null) {
			encoding = "UTF-8";
		}

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// request
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);

		// response
		
		
		
	}

}
