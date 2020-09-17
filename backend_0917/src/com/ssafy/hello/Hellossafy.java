package com.ssafy.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hellossafy
 */
@WebServlet("/Hellossafy.do")
public class Hellossafy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String name;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hellossafy() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	name = "안효인";
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get call!!!!");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html");
		response.setContentType("text/html;charset=UTF-8"); // 순서가 중요! getWriter하기 전에~
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		out.println("		Hello SSAFY!<br>");
		out.println("		안녕 싸피!<br>");
		out.println("		안녕 " + name + "!!!!!<br>");
		out.println("	</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post call!!!!");
//		doGet(request, response);
	}

}
