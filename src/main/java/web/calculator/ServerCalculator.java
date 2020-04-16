package web.calculator;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import javax.servlet.Servlet;

public class ServerCalculator {
    public static void main(String[] args) throws Exception {
       Server server=new Server(8000);
        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(Servlet.class, "/calc");


        server.setHandler(handler);
        server.start();
        server.join();
    }
}
