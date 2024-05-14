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

        boolean loginStatus = false;

        // Check if the date of birth is not empty before invoking the login service
        if (!dob.isEmpty()) {
            loginStatus = LoginService.login(username, password, dob);
        }

        // Set response content type to HTML
        resp.setContentType("text/html");

        // Generate HTML response
        String htmlResponse = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Login Response</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Login Status: " + (loginStatus ? "Success" : "Fail") + "</h1>\n" +
                "</body>\n" +
                "</html>";

        // Write the HTML response to the PrintWriter
        PrintWriter writer = resp.getWriter();
        writer.println(htmlResponse);
        writer.flush(); // Flush the writer to ensure the response is sent
    }




}
