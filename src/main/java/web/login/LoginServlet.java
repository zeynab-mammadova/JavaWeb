package web.login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.stream.Collectors;

public class LoginServlet extends HttpServlet {

  private  final Auth auth;

  public LoginServlet(Auth auth) {
    this.auth = auth;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String content = new BufferedReader(new FileReader(new File("src/main/resources/templates/login.html"))).lines()
            .collect(Collectors.joining("\n"));

    try (PrintWriter writer = resp.getWriter()) {
      writer.write(content);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String name = req.getParameter("name");
    String password = req.getParameter("password");
    System.out.printf("name:%s\n",name);
    System.out.printf("password:%s\n",password);
    Auth auth = new AuthHash();
    try (PrintWriter w = resp.getWriter()) {
      if (auth.check(name, password)) {
        w.printf("LOGIN SUCCESSFULLY");
      } else {
        w.printf("THERE IS NO SUCH USER");
      }
    }
  }
}
