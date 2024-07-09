package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import util.ImcResultadoUtil;

@WebServlet("/calcularIMC")
public class ImcResultado extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            double weight = Double.parseDouble(request.getParameter("weight"));
            double height = Double.parseDouble(request.getParameter("height"));
            double imc = ImcResultadoUtil.calcularIMC(weight, height);
            
            request.setAttribute("imc", imc);
            request.getRequestDispatcher("imcresultado.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.getWriter().append("Error: valores númericos solamente.");
        } catch (IllegalArgumentException e) {
            response.getWriter().append("Error: " + e.getMessage());
        }
    }
}
