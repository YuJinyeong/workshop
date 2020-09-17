package com.ssafy.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ggd.do")
public class Gugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<head>");
		out.println("	<title>구구단(Servlet)</title>");
		out.println("	<style type=\"text/css\">");
		out.println("		table {width:800px; height:800px;}");
		out.println("		.color1 {background-color : steelblue;}");
		out.println("		.color2 {background-color : magenta;}");
		out.println("	</style>");
		out.println("	</head>");
		out.println("	<body>");
		out.println("	<div align=\"center\">");
		out.println("	<h3>구구단(Servlet)</h3>");
		out.println("	<table>");
		for(int dan=2;dan<10;dan++) {
			out.println("	<tr align=\"center\">");
			String classname = dan % 2 == 0 ? "color1" : "color2";
			for(int i=1;i<10;i++) {
				out.println("	<td class=\"" + classname + "\">" + dan + " * " + i + " = " + dan * i + "</td>");
			}
			out.println("	</tr>");
		}
		out.println("	</table>");
		out.println("	</div>");
		out.println("	</body>");
		out.println("</html>");
	}

}
