package com.ssafy.webex;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ssafy.webex.model.Adder;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
