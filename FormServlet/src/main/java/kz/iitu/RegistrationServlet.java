package kz.iitu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/register")
public class RegistrationServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println("Welcome ");
        String name = request.getParameter("name");
        out.println(name);
        String surname = request.getParameter("surname");
        out.println(surname);
        String email = request.getParameter("email");
        out.println(email);
        String username = request.getParameter("username");
        out.println(username);
        String password = request.getParameter("password");
        out.println(password);

    }

}
