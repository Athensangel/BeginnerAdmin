package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import model.User;
import until.JDBCConn;

public class UserDaoImpl implements UserDao {
	/**
	 * 用户登录
	 */
	@Override
	public User checkLogin(String username, String password) {
		Connection conn = JDBCConn.getConn();
		User user = new User();
		String sql = "select * from user where username=? and password=?";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				user.setToid(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassWord(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * 查询user的表里的字段
	 */
	@Override
	public List<User> findAllUsers() {
		Connection conn = JDBCConn.getConn();
		List<User> UserList = new ArrayList<User>();
		StringBuffer sb = new StringBuffer("select a.toid toid,a.username userName,a.`password` passWord,a.realname realName,a.sex sex,a.birthday birthday,a.email email,a.address address,a.telphone telphone,a.qq qq,a.salary salary,a.departid departId,a.role role, b.departmentname AS departmentName from user a ");
		sb.append("LEFT JOIN department b on b.toid = a.departid");
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sb.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setToid(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassWord(rs.getString(3));
				user.setRealName(rs.getString(4));
				user.setSex(rs.getString(5));
				user.setBirthday(rs.getString(6));
				user.setEmail(rs.getString(7));
				user.setAddress(rs.getString(8));
				user.setTelphone(rs.getString(9));
				user.setQq(rs.getString(10));
				user.setSalary(rs.getFloat(11));
				user.setDepartId(rs.getInt(12));
				user.setRole(rs.getString(13));
				user.setDepartmentName(rs.getString(14));
				UserList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return UserList;
	}

	/**
	 * 添加用户
	 */
	@Override
	public void insertUser(User user) {
		Connection conn = JDBCConn.getConn();
		String sql = "insert into user(username,password,realname,sex,birthday,email,address,telphone,qq,salary,departid,role) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassWord());
			pstmt.setString(3, user.getRealName());
			pstmt.setString(4, user.getSex());
			pstmt.setString(5, user.getBirthday());
			pstmt.setString(6, user.getEmail());
			pstmt.setString(7, user.getAddress());
			pstmt.setString(8, user.getTelphone());
			pstmt.setString(9, user.getQq());
			pstmt.setFloat(10, user.getSalary());
			pstmt.setInt(11, user.getDepartId());
			pstmt.setString(12, user.getRole());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * 删除数据
	 */
	@Override
	public void delUserById(Integer toid) {
		Connection conn = JDBCConn.getConn();
	    String sql = "delete from user where toid= ?"; 
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        pstmt.setInt(1,toid);
	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	/**
	 * toId更新数据
	 */
	@Override
	public User findUserById(Integer toid) {
		Connection conn = JDBCConn.getConn();
		User user = new User();
	    String sql = "select * from user where toid=?"; 
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        pstmt.setInt(1,toid);
	        ResultSet rs = pstmt.executeQuery();
	        while (rs.next()) {
	        	user.setToid(rs.getInt(1));
	        	user.setUserName(rs.getString(2));
	        	user.setPassWord(rs.getString(3));
		        user.setRealName(rs.getString(4));
		        user.setSex(rs.getString(5));
		        user.setBirthday(rs.getString(6));
		        user.setEmail(rs.getString(7));
		        user.setAddress(rs.getString(8));
		        user.setTelphone(rs.getString(9));
		        user.setQq(rs.getString(10));
		        user.setSalary(rs.getFloat(11));
		        user.setDepartId(rs.getInt(12));
		        user.setRole(rs.getString(13));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return user;
	}

	@Override
	public void updateUserById(User user) {
		Connection conn = JDBCConn.getConn();
	    String sql = "update user set username = ?,password = ?,realname = ?,sex = ?,birthday = ?,email = ?,address = ?,telphone = ?,qq = ?,salary = ?,departid = ?,role = ? where toid = ?"; 
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        pstmt.setString(1,user.getUserName());		//setString 是为第一个参数设置一个 string 类型的值testNumber
	        pstmt.setString(2, user.getPassWord());
	        pstmt.setString(3, user.getRealName());
	        pstmt.setString(4,user. getSex());
	        pstmt.setString(5, user.getBirthday());
	        pstmt.setString(6, user.getEmail());
	        pstmt.setString(7,user.getAddress());
	        pstmt.setString(8, user.getTelphone());
	        pstmt.setString(9, user.getQq());
	        pstmt.setFloat(10,user.getSalary());
	        pstmt.setInt(11, user. getDepartId());
	        pstmt.setString(12, user.getRole());
	        pstmt.setInt(13, user.getToid());
	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	/**
	 * 更新数据
	 */
	@Override
	public void updateUserInfo(User user) {
		Connection conn = JDBCConn.getConn();
		String sql ="update user set username=?,password=?,realname=?,sex=?,birthday=?,email=?,address=?,telphone=?,qq=?,salary=?,departid=?,role=? where toid=?";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassWord());
			pstmt.setString(3, user.getRealName());
			pstmt.setString(4, user.getSex());
			pstmt.setString(5, user.getBirthday());
			pstmt.setString(6, user.getEmail());
			pstmt.setString(7, user.getAddress());
			pstmt.setString(8, user.getTelphone());
			pstmt.setString(9, user.getQq());
			pstmt.setFloat(10, user.getSalary());
			pstmt.setInt(11, user.getDepartId());
			pstmt.setString(12, user.getRole());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
