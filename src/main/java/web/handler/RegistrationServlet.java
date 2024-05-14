package web.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.RegistrationService;

/**
 * HTTP end-point to handle registration request.
 */
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("[RegistrationServlet] GET");

        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("[RegistrationServlet] POST");

        String fName = req.getParameter("fname");
        String lName = req.getParameter("lname");
        String email = req.getParameter("email");
        String dob = req.getParameter("dob");

        // Call registration business logic
        boolean registrationStatus = RegistrationService.register(fName, lName, email, dob);

        // Set response content type to JSON
        resp.setContentType("application/json");

        // Generate JSON response
        String jsonResponse = "{\"status\": \"" + (registrationStatus ? "success" : "fail") + "\"}";

        // Write the JSON response
        resp.getWriter().println(jsonResponse);
    }
}
