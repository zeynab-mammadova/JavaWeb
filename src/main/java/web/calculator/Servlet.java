package web.calculator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String a = req.getParameter("a");
        String b = req.getParameter("b");
        String op = req.getParameter("op");

        String path = req.getPathInfo();

        Calculator calculator = new Calculator();
        try (PrintWriter writer = resp.getWriter()){
            writer.printf("a = %s", a);
            writer.printf("b = %s", b);
            writer.printf("res = %s ", calculator.operate(a,b,op));
            writer.println(path);
        }
    }
}
