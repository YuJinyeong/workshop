package com.ssafy.life;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lifecycle.do")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public LifeCycle() {
		System.out.println("Constructor() Call!!!!!");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init() Call!!!!!");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() Call!!!!!");
	}

	@Override
	public void destroy() {
		System.out.println("doPost() Call!!!!!");
	}
}
