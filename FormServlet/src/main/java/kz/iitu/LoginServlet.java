package kz.iitu;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Login Post");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String status = "false";

        ServletConfig config = getServletConfig();
        Enumeration<String> elements = config.getInitParameterNames();

        while (elements.hasMoreElements()){
            String elementUsername = elements.nextElement();
            String elementsPassword = config.getInitParameter(elementUsername);

            if (elementUsername.equals(username) && elementsPassword.equals(password)){
                status = "true";
                break;
            }
        }

        request.setAttribute("status", status);

        if (status.equals("true")){
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            PrintWriter out = response.getWriter();
            out.println("Welcome ");
            String uname = request.getParameter("username");
            out.println(uname);
            String pass = request.getParameter("password");
            out.println(pass);
        } else{
            System.out.println("Go Login Page");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

}
