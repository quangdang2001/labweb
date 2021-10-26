package com.lab9.Lab9.data;

import com.lab9.Lab9.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
     public Connection getConnection() {
        try {
            String url = "jdbc:mysql://becf340aa2d7a1:2e676f13@us-cdbr-east-04.cleardb.com/heroku_e21899dacad2c66?";
            String user = "becf340aa2d7a1";
            String password = "2e676f13";
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
        String query = "Select * from product where ProductCode = ?";
        statement = connection.prepareStatement(query);
        statement.setString(1,code);
        resultSet = statement.executeQuery();
        if (resultSet.next()){
            Product product = new Product();
            product.setCode(resultSet.getString("ProductCode"));
            product.setDescription(resultSet.getString("ProductDescription"));
            product.setPrice(resultSet.getDouble("ProductPrice"));
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
                    product.setCode(resultSet.getString("ProductCode"));
                    product.setDescription(resultSet.getString("ProductDescription"));
                    product.setPrice(resultSet.getDouble("ProductPrice"));
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
