import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/addBook.do")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		//할일하고(로그를 찍는다거나... 기록을 남기는거지... 보안정책을 수행한다거나...
		
		//보여주러가자.
		request.getRequestDispatcher("Book.html").forward(request, response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");
		// TODO Auto-generated method stub
		String isbn = request.getParameter("num1") + "-" +request.getParameter("num2") + "-" +request.getParameter("num3");
		String title = request.getParameter("title");
		String publisher = request.getParameter("publisher");
		//입력받은 정보를.. DB에 저장하는 작업을 수행.
		System.out.println(isbn);
		System.out.println(title);
		System.out.println(publisher);
		//잘 저장되었으면. 잘 저장한 방금 그 정보들을 웹페이지에 보여주자 :)
		request.setAttribute("isbn", isbn);
		request.setAttribute("title", title);
		request.setAttribute("publisher", publisher);
		request.getRequestDispatcher("bookDetail.jsp").forward(request, response);

	}

}
