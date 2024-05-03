package web.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.LoginService;

/**
 * HTTP end-point to handle login service.
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("[LoginServlet] GET");

        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("[LoginServlet] POST");

        String username = req.getParameter("username");
        String password = req.getParameter("passwd");
        String dob = req.getParameter("dob");

        System.out.println("Username/password: " + username + ", " + password);

        boolean loginStatus = LoginService.login(username, password, dob);

        // Set response content type to JSON
        resp.setContentType("application/json");

        // Create a JSON response
        String jsonResponse = "{\"status\": \"" + (loginStatus ? "success" : "fail") + "\"}";

        // Write the JSON response to the PrintWriter
        PrintWriter writer = resp.getWriter();
        writer.println(jsonResponse);
    }
}