package com.example.lab_1jt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/graphMatrix")
public class GraphMatrixServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Log request information
        logRequestDetails(request);

        // Get parameters
        String numVerticesParam = request.getParameter("numVertices");
        String numEdgesParam = request.getParameter("numEdges");

        // Parse parameters
        int numVertices = Integer.parseInt(numVerticesParam);
        int numEdges = Integer.parseInt(numEdgesParam);

        // Generate adjacency matrix
        int[][] adjacencyMatrix = generateRandomGraph(numVertices, numEdges);

        // Set the response content type to HTML
        response.setContentType("text/html");

        // Prepare the HTML response
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Adjacency Matrix</h1>");
        out.println("<table border='1'>");

        for (int i = 0; i < numVertices; i++) {
            out.println("<tr>");
            for (int j = 0; j < numVertices; j++) {
                out.println("<td>" + adjacencyMatrix[i][j] + "</td>");
            }
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body></html>");
    }

    private void logRequestDetails(HttpServletRequest request) {
        String method = request.getMethod();
        String ipAddress = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");
        String languages = request.getHeader("Accept-Language");
        String numVertices = request.getParameter("numVertices");
        String numEdges = request.getParameter("numEdges");

        System.out.println("Request Method: " + method);
        System.out.println("Client IP: " + ipAddress);
        System.out.println("User-Agent: " + userAgent);
        System.out.println("Client Languages: " + languages);
        System.out.println("Parameters - numVertices: " + numVertices + ", numEdges: " + numEdges);
    }

    private int[][] generateRandomGraph(int numVertices, int numEdges) {
        int[][] matrix = new int[numVertices][numVertices];
        Random random = new Random();

        // Ensure the number of edges is valid
        int maxEdges = numVertices * (numVertices - 1) / 2;
        numEdges = Math.min(numEdges, maxEdges);

        // Randomly add edges
        while (numEdges > 0) {
            int from = random.nextInt(numVertices);
            int to = random.nextInt(numVertices);
            if (from != to && matrix[from][to] == 0) {
                matrix[from][to] = 1;
                matrix[to][from] = 1;
                numEdges--;
            }
        }

        return matrix;
    }
}
