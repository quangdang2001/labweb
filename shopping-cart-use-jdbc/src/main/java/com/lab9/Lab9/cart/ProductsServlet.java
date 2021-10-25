package com.lab9.Lab9.cart;

import com.lab9.Lab9.data.ProductDAO;
import com.lab9.Lab9.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;



@WebServlet(urlPatterns = {"/loadProducts"})
public class ProductsServlet extends HttpServlet {
    ProductDAO productDAO;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        productDAO = new ProductDAO();
        HttpSession session = request.getSession();
        String path = getServletContext().getRealPath("/WEB-INF/image");
        List<Product> products = productDAO.findAll();
        session.setAttribute("products", products);
        request.setAttribute("products",products);
        String url = "index.jsp";
        RequestDispatcher dp = request.getRequestDispatcher(url);
        dp.forward(request,response);
    }
}
