package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDao;
import model.Product;
import until.JDBCConn;

public class ProductDaoImpl implements ProductDao {
	/**
	 * 查询Product表中的所有信息
	 */
	@Override
	public List<Product> findAllProduct() {
	Connection conn=JDBCConn.getConn();
	List<Product> ProductList=new ArrayList<Product>();
	String sql="select * from product";
	PreparedStatement pstmt;
	try {
		pstmt=(PreparedStatement)conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			Product product=new Product();
			product.setToId(rs.getInt(1));
			product.setProductName(rs.getString(2));;
			product.setPrice(rs.getFloat(3));
			ProductList.add(product);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return ProductList;
	}
	/**
	 * 添加产品信息
	 */
	@Override
	public void InsertProduct(Product product) {
		Connection conn=JDBCConn.getConn();
		String sql="insert into product(productName,Price) values(?,?)";
		PreparedStatement pstmt;
		try {
			pstmt=(PreparedStatement)conn.prepareStatement(sql);
			pstmt.setString(1,product.getProductName());
			pstmt.setFloat(2,product.getPrice());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 删除数据
	 */
	@Override
	public void delProductById(Integer toid) {
		Connection conn=JDBCConn.getConn();
		String sql="delete from product where toid=?";
		PreparedStatement pstmt;
		try {
			pstmt=(PreparedStatement)conn.prepareStatement(sql);
			pstmt.setInt(1, toid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * toId更新数据
	 */
	@Override
	public Product findProductById(Integer toid) {
		Connection conn=JDBCConn.getConn();
		Product product=new Product();
		String sql="select * from product where toid=?";
		PreparedStatement pstmt;
		try {
			pstmt=(PreparedStatement)conn.prepareStatement(sql);
			pstmt.setInt(1,toid);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				product.setToId(rs.getInt(1));
				product.setProductName(rs.getString(2));;
				product.setPrice(rs.getFloat(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return product;
	}

	@Override
	public void updateProductById(Product product) {
		Connection conn=JDBCConn.getConn();
		String sql="update product set productname=?,price=? where toid=?";
		PreparedStatement pstmt;
		try {
			pstmt=(PreparedStatement)conn.prepareStatement(sql);
			pstmt.setString(1,product.getProductName());
			pstmt.setFloat(2,product.getPrice());
			pstmt.setInt(3, product.getToId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateProductInfo(Product product) {
		Connection conn=JDBCConn.getConn();
		String sql="update product set productName=?,Price=? where toid=?";
		PreparedStatement pstmt;
		try {
			pstmt=(PreparedStatement)conn.prepareStatement(sql);
			pstmt.setString(1,product.getProductName());
			pstmt.setFloat(2,product.getPrice());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
