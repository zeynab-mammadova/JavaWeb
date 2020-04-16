package web.login;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class LoginServer {
  public static void main(String[] args) throws Exception {
    Server server = new Server(7070);
    ServletContextHandler handler = new ServletContextHandler();
    Auth auth = new AuthHash();
    LoginServlet login = new LoginServlet(auth);
    handler.addServlet(new ServletHolder(login), "/login/*");
    handler.addServlet(new ServletHolder(new FileContentServlet()), "/file/*");
    server.setHandler(handler);
    server.start();
    server.join();
  }
}
