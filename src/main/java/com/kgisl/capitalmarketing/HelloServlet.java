package com.kgisl.capitalmarketing;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.kgisl.capitalmarketing.pojo.Template;
import com.kgisl.capitalmarketing.service.ServicStock;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

        // Get form data
        String stockId = request.getParameter("stockid");
        String symbol = request.getParameter("symbol");
        String company = request.getParameter("company");
        String currentPrice = request.getParameter("current");
        String date = request.getParameter("date");

        if (stockId == null || symbol == null || company == null || currentPrice == null || date == null ||
            stockId.trim().isEmpty() || symbol.trim().isEmpty() || company.trim().isEmpty() || currentPrice.trim().isEmpty() || date.trim().isEmpty()) {
            request.setAttribute("errorMessage", "All fields are required.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        // Insert data into the database
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                 "INSERT INTO stock VALUES (?, ?, ?, ?, ?)")) {

            statement.setString(1, stockId);
            statement.setString(2, symbol);
            statement.setString(3, company);
            statement.setDouble(4, Double.parseDouble(currentPrice));
            statement.setDate(5, java.sql.Date.valueOf(date));
            statement.executeUpdate();

        } catch (SQLException e) {
            request.setAttribute("errorMessage", "Error occurred while saving data.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        // Redirect to a success page or back to the form
        response.sendRedirect("success.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServicStock service = new ServicStock();
        List<Template> list = service.read();
        req.setAttribute("itemList", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);

    }
}
