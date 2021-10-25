package com.lab9.Lab9.data;

import com.lab9.Lab9.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/shopping_cart";
            String user = "root";
            String password = "2211";
            Class.forName("com.mysql.jdbc.Driver");

            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

    public Product findById(String code) throws SQLException {

        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "Select * from product where code = ?";
        statement = connection.prepareStatement(query);
        statement.setString(1,code);
        resultSet = statement.executeQuery();
        if (resultSet.next()){
            Product product = new Product();
            product.setCode(resultSet.getString("code"));
            product.setDescription(resultSet.getString("description"));
            product.setPrice(resultSet.getDouble("price"));
            return product;
        }
        if (connection != null)
            connection.close();
        if (statement != null)
            statement.close();
        if (resultSet != null)
            resultSet.close();
        return null;
    }


    public List<Product> findAll() {
        List<Product> products = new ArrayList<Product>();
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "Select * from product";

        if (connection != null) {
            try {
                statement = connection.prepareStatement(query);
                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    Product product = new Product();
                    product.setCode(resultSet.getString("code"));
                    product.setDescription(resultSet.getString("description"));
                    product.setPrice(resultSet.getDouble("price"));
                    products.add(product);
                }
                return products;

            } catch (SQLException e) {
                return null;
            } finally {
                try {
                    if (connection != null)
                        connection.close();
                    if (statement != null)
                        statement.close();
                    if (resultSet != null)
                        resultSet.close();
                } catch (SQLException e2) {
                    return null;
                }
            }
        }
        return null;
    }
}
