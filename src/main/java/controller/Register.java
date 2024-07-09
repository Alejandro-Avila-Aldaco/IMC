package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import util.DBConnection;

@WebServlet("/register")
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullname = request.getParameter("fullname");
        int age = Integer.parseInt(request.getParameter("age"));
        String sex = request.getParameter("sex");
        double height = Double.parseDouble(request.getParameter("height"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (age < 15 || height < 1 || height > 2.5) {
            response.getWriter().append("Datos inválidos");
            return;
        }

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBConnection.getConnection();
            String sql = "INSERT INTO users (fullname, age, sex, height, username, password) VALUES (?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, fullname);
            stmt.setInt(2, age);
            stmt.setString(3, sex);
            stmt.setDouble(4, height);
            stmt.setString(5, username);
            stmt.setString(6, password);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                response.sendRedirect("login.jsp");
                return;
            } else {
                response.getWriter().append("Error en el registro.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().append("Error en la base de datos: " + e.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
