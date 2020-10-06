package com.ssafy.webex;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ssafy.webex.model.Adder;
import com.ssafy.webex.model.UserDao;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/main")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("add")) {
            add(request, response);
        } else if (action.equals("logout")) {
            logout(request, response);
        } else if (action.equals("makeCookie")) {
            makeCookie(request, response);
        } else if (action.equals("checkCookie")) {
            checkCookie(request, response);
        }
    }



    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action.equals("login")) {
            login(request, response);
        }
    }

    protected void checkCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 클라이언트에서 전달된 쿠키를 이용해서 login 해보자.
        Cookie[] cookies = request.getCookies();
        boolean login = false;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("name")) {// 쿠키가 있다면 이것을 로그인 계정이라고 간주하자.
                login = true;
                HttpSession session = request.getSession();
                session.setAttribute("loginUser", cookie.getValue());
                // redirect or forward??
                response.sendRedirect(request.getContextPath() + "/webex/loginresult.jsp");
                break;
            }
        }
        if (!login) {
            response.sendRedirect(request.getContextPath() + "/webex/login.jsp");
        }
    }

    protected void makeCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 쿠키 생성
        Cookie cookie = new Cookie("name", "홍길동");
        // 유효기간
        cookie.setMaxAge(60 * 2);
        // 경로
        cookie.setPath("/");
        // 전달
        response.addCookie(cookie);

        Cookie cookie2 = new Cookie("age", "30");
        cookie2.setPath("/");
        response.addCookie(cookie2);

        Cookie cookie3 = new Cookie("addr", "seoul");
        cookie3.setMaxAge(0);
        cookie3.setPath("/");
        response.addCookie(cookie3);

        RequestDispatcher disp = request.getRequestDispatcher("/webex/cookieConsumer.jsp");
        disp.forward(request, response);
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 파라미터 확보
        // 2. model 연결
        // 세션 정리
        HttpSession session = request.getSession();
        session.invalidate();// 그 사용자의 세션 정리하기
        response.sendRedirect(request.getContextPath() + "/webex/login.jsp");
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 파라미터 확보
        String id = request.getParameter("id");
        String pass = request.getParameter("pass");
        // 2. model 연결
        UserDao dao = UserDao.getDao();
        boolean result = dao.login(id, pass);
        if (result) {
            // 3. 화면 연결
            // 3-1 화면에서 필요한 데이터 설정
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", id);
            // redirect or forward??
            response.sendRedirect(request.getContextPath() + "/webex/loginresult.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/webex/login.jsp");
        }
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Controller 역할 1: 파라미터 검증
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        // Controller 역할 2: 비지니스 로직 처리 위임
        int result = Adder.add(num1, num2);
        // Controller 역할 3: 화면 연결
        request.setAttribute("result", result);// 추가적인 데이터 전달
        // dispatcher: /의 의미는 context root
        // RequestDispatcher disp = request.getRequestDispatcher("/webex/addresult.jsp");
        // disp.forward(request, response);
        // send redirect: /의 의미는 container root --> context root 개입 필요
        // 처음 요청이 response 한 후에도 정보를 유지하도록 세션 사용하자.
        HttpSession session = request.getSession();
        session.setAttribute("num1", num1);
        session.setAttribute("num2", num2);
        session.setAttribute("result", result);

        response.sendRedirect(request.getContextPath() + "/webex/addresult.jsp");
    }

}
