package com.example.lab_1jt;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/stringToList")
public class StringToListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the input string from the query parameter
        String inputString = request.getParameter("inputString");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Characters of the String as Ordered List</h1>");

        if (inputString != null && !inputString.isEmpty()) {
            out.println("<ol>");
            for (char ch : inputString.toCharArray()) {
                out.println("<li>" + ch + "</li>");
            }
            out.println("</ol>");
        } else {
            out.println("<p>No input string provided!</p>");
        }
        out.println("</body></html>");
    }
}
