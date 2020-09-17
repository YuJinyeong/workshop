package com.ssafy.guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/articlelist.do")
public class GuestBookList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. data get
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"ko\">");
		out.println("<head>");
		out.println("  <title>SSAFY - 글목록</title>");
		out.println("  <meta charset=\"utf-8\">");
		out.println("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.println("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css\">");
		out.println("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>");
		out.println("  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\"></script>");
		out.println("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\"></script>");
		out.println("	<script type=\"text/javascript\">");
		out.println("	$(document).ready(function() {");
		out.println("		$(\"#mvWriteBtn\").click(function() {");
		out.println("			$(location).attr(\"href\", \"/guestbookservlet/guestbook/write.html\");");
		out.println("		});");
		out.println("	});");
		out.println("	</script>");
		out.println("</head>");
		out.println("<body>");
		out.println("");
		out.println("<div class=\"container\" align=\"center\">");
		out.println("  <div class=\"col-lg-8\" align=\"center\">");
		out.println("  <h2>글목록</h2>");
		out.println("  <p>좋은글 많이 올려 주세요!!!!!</p>  ");
		out.println("  <table class=\"table table-borderless\">");
		out.println("  	<tr>");
		out.println("  		<td align=\"right\"><button type=\"button\" id=\"mvWriteBtn\" class=\"btn btn-link\">글쓰기</button></td>");
		out.println("  	</tr>");
		out.println("  </table>");
//		2. logic
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ssafyweb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "ssafy", "ssafy");
			StringBuilder sql = new StringBuilder();
			sql.append("select articleno, username, subject, content, regtime \n");
			sql.append("from guestbook \n");
			sql.append("order by articleno desc \n");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				out.println("  <table class=\"table table-active\">");
				out.println("    <tbody>");
				out.println("      <tr class=\"table-info\">");
				out.println("        <td>작성자 : " + rs.getString("username") + "</td>");
				out.println("        <td align=\"right\">작성일 : " + rs.getString("regtime") + "</td>");
				out.println("      </tr>");
				out.println("      <tr>");
				out.println("        <td colspan=\"2\" class=\"table-danger\"><strong>" + rs.getInt("articleno") + ". " + rs.getString("subject") + "</strong></td>");
				out.println("      </tr>");
				out.println("      <tr>");
				out.println("        <td colspan=\"2\">" + rs.getString("content") + "</td>");
				out.println("      </tr>");
				out.println("    </tbody>");
				out.println("  </table>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		out.println("  </div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

}
