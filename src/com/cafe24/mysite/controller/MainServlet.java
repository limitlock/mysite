package com.cafe24.mysite.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mvc.action.Action;
import com.cafe24.mysite.action.main.MainActionFactory;

//@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	
	@Override
	public void init() throws ServletException {
		ServletConfig servletConfig = getServletConfig();
		String configPath = servletConfig.getInitParameter("config");
		System.out.println("init() called : "+configPath);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	

		String actionName = request.getParameter("a");
		Action action = new MainActionFactory().getAction(actionName);
		action.execute(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
