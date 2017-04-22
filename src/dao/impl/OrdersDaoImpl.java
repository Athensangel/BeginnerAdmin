package dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.OrdersDao;
import model.Orders;
import until.JDBCConn;

public class OrdersDaoImpl implements OrdersDao {
	/**
	 * 查询Orders表中的所有信息
	 */
	@Override
	public List<Orders> queryAllOrders() {
		Connection conn=JDBCConn.getConn();
		List<Orders> OrdersList=new ArrayList<Orders>();
		StringBuffer sBuffer = new StringBuffer("select a.toid AS toid,a.custname custName, a.custaddress custAddress,a.custphone custPhone,a.custemail custEmail,a.odertime oderTime,");
		sBuffer.append("a.productid productId,a.productcount productCount,a.money money,a.createtime  createTime,b.realname userRealName from orders a ");
		sBuffer.append("LEFT JOIN `user` b on b.toid = a.userid ");
		PreparedStatement pstmt;
		try {
			pstmt=(PreparedStatement)conn.prepareStatement(sBuffer.toString());
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				Orders orders=new Orders();
				orders.setToid(rs.getInt(1));
				orders.setCustName(rs.getString(2));
				orders.setCustAddress(rs.getString(3));
				orders.setCustPhone(rs.getString(4));
				orders.setCustEmail(rs.getString(5));
				orders.setOderTime(rs.getString(6));
				orders.setProductId(rs.getInt(7));
				orders.setProductCount(rs.getInt(8));
				orders.setMoney(rs.getFloat(9));
				orders.setCreateTime(rs.getString(10));
				orders.setUserRealName(rs.getString(11));
				OrdersList.add(orders);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return OrdersList;
	}
	/**
	 * 添加订单信息
	 */
	@Override
	public void insertOrders(Orders orders) {
		Connection conn=JDBCConn.getConn();
		String sql="insert into orders(custname,custaddress,custphone,custemail,odertime,productid,productcount,money,createtime,userid) values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt=(PreparedStatement)conn.prepareStatement(sql);
			pstmt.setString(1,orders.getCustName());
			pstmt.setString(2,orders.getCustAddress());
			pstmt.setString(3,orders.getCustPhone());
			pstmt.setString(4,orders.getCustEmail());
			pstmt.setString(5,orders.getOderTime());
			pstmt.setInt(6,orders.getProductId());
			pstmt.setInt(7,orders.getProductCount());
			pstmt.setFloat(8,orders.getMoney());
			pstmt.setString(9,orders.getCreateTime());
			pstmt.setInt(10,orders.getUserId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 删除数据
	 */
	@Override
	public void delOrdersById(Integer toid) {
		Connection conn=JDBCConn.getConn();
		String sql="delete from orders where toid=?";
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
	public Orders findOrdersById(Integer toid) {
		Connection conn=JDBCConn.getConn();
		Orders orders=new Orders();
		String sql="select * from orders where toid=?";
		PreparedStatement pstmt;
		try {
			pstmt=(PreparedStatement)conn.prepareStatement(sql);
			pstmt.setInt(1,toid);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				orders.setToid(rs.getInt(1));
				orders.setCustName(rs.getString(2));
				orders.setCustAddress(rs.getString(3));
				orders.setCustPhone(rs.getString(4));
				orders.setCustEmail(rs.getString(5));
				orders.setOderTime(rs.getString(6));
				orders.setProductId(rs.getInt(7));
				orders.setProductCount(rs.getInt(8));
				orders.setMoney(rs.getFloat(9));
				orders.setCreateTime(rs.getString(10));
				orders.setUserId(rs.getInt(11));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return orders;
	}
/**
 * 修改数据
 * @param orders
 */
	@Override
	public void updateOrdersById(Orders orders) {
		Connection conn=JDBCConn.getConn();
		String sql="update orders set custname=?,custaddress=?,custphone=?,custemail=? ,odertime=?,productid=?,productcount=?,money=?,createtime=?,userid=? where toid=?";
		PreparedStatement pstmt;
		try {
			pstmt=(PreparedStatement)conn.prepareStatement(sql);
			pstmt.setString(1,orders.getCustName());
			pstmt.setString(2,orders.getCustAddress());
			pstmt.setString(3,orders.getCustPhone());
			pstmt.setString(4,orders.getCustEmail());
			pstmt.setString(5,orders.getOderTime());
			pstmt.setInt(6,orders.getProductId());
			pstmt.setInt(7,orders.getProductCount());
			pstmt.setFloat(8,orders.getMoney());
			pstmt.setString(9,orders.getCreateTime());
			pstmt.setInt(10,orders.getUserId());
			pstmt.setInt(11,orders.getToid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateOrdersInfo(Orders orders) {
		
	}

}
