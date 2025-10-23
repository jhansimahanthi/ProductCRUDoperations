package com.codegnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codegnan.model.Product;
import com.codegnan.util.DBConnectionUtil;

public class ProductDaoImpl implements ProductDao {
	

	
	    @Override
	    public void addProduct(Product product) {
	        String sql = "INSERT INTO product(productId, productName, price, category) VALUES(?, ?, ?, ?)";
	        try(Connection conn = DBConnectionUtil.getConnection();
	            PreparedStatement ps = conn.prepareStatement(sql)) {

	            ps.setInt(1, product.getProductId());
	            ps.setString(2, product.getProductName());
	            ps.setDouble(3, product.getPrice());
	            ps.setString(4, product.getCategory());
	            ps.executeUpdate();
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public Product getProductById(int id) {
	        String sql = "SELECT * FROM product WHERE productId = ?";
	        try(Connection conn = DBConnectionUtil.getConnection();
	            PreparedStatement ps = conn.prepareStatement(sql)) {

	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()) {
	                return new Product(rs.getInt("productId"), rs.getString("productName"), rs.getDouble("price"), rs.getString("category"));
	            }
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    @Override
	    public List<Product> getAllProducts() {
	        List<Product> productList = new ArrayList<>();
	        String sql = "SELECT * FROM product";
	        try(Connection conn = DBConnectionUtil.getConnection();
	            Statement stmt = conn.createStatement()) {

	            ResultSet rs = stmt.executeQuery(sql);
	            while(rs.next()) {
	                productList.add(new Product(rs.getInt("productId"), rs.getString("productName"), rs.getDouble("price"), rs.getString("category")));
	            }
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	        return productList;
	    }

	    @Override
	    public void deleteProduct(int id) {
	        String sql = "DELETE FROM product WHERE productId = ?";
	        try(Connection conn = DBConnectionUtil.getConnection();
	            PreparedStatement ps = conn.prepareStatement(sql)) {

	            ps.setInt(1, id);
	            ps.executeUpdate();
	        } catch(SQLException e) {
	            e.printStackTrace();
	        }
	    }
	




}
