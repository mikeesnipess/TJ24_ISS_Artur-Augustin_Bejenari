package com.example.lab4_jt;

import com.example.lab4_jt.Client;
import com.example.lab4_jt.ClientService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/clients")
public class ClientServlet extends HttpServlet {

    @Inject
    private ClientService clientService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Client> clients = clientService.getAllClients();
        request.setAttribute("clients", clients);
        request.getRequestDispatcher("clients.jsp").forward(request, response);
    }
}
