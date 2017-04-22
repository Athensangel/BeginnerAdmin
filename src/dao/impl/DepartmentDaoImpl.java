package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DepartmentDao;
import model.Department;
import until.JDBCConn;

/**
 * DepartmentDaoImpl跟数据打交道
 * @author Administrator
 *
 */
public class DepartmentDaoImpl implements DepartmentDao {
	/**
	 * Department信息
	 */
	@Override
	public List<Department> findAllDepartment() {
		Connection conn=JDBCConn.getConn();
		List<Department> departmentList=new ArrayList<Department>();
		StringBuffer sb = new StringBuffer("SELECT a.toid toId,a.departmentname AS departmentName,b.realname AS realName FROM department a ");
		sb.append("LEFT JOIN `user` b on b.departid = a.toid");
		PreparedStatement pstmt;
		try {
			pstmt=(PreparedStatement)conn.prepareStatement(sb.toString());
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				Department department=new Department();
				department.setToId(rs.getInt(1));
				department.setDepartmentName(rs.getString(2));
				department.setUserRealName(rs.getString(3));
				departmentList.add(department);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return departmentList;
	}
	/**
	 * Department信息
	 */
	@Override
	public void insertDepartment(Department department) {
		Connection conn=JDBCConn.getConn();
		String sql="insert into department(departmentname,managerid) values(?,?)";
		PreparedStatement pstmt;
		try {
			pstmt=(PreparedStatement)conn.prepareStatement(sql);
			pstmt.setString(1,department.getDepartmentName());
			pstmt.setInt(2,department.getManagerId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 删除Department信息
	 */
	@Override
	public void delDepartmentById(Integer toid) {
		Connection conn=JDBCConn.getConn();
		String sql="delete from department where toid=?";
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
	 * Department用toId更新数据 
	 */
	@Override
	public Department findDepartmentById(Integer toid) {
		Connection conn=JDBCConn.getConn();
		Department department=new Department();
		String sql="select * from department  where toid=?";
		PreparedStatement pstmt;
		try {
			pstmt=(PreparedStatement)conn.prepareStatement(sql);
			pstmt.setInt(1,toid);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				department.setToId(rs.getInt(1));
				department.setDepartmentName(rs.getString(2));
				department.setManagerId(rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return department;
	}
	/**
	 * 修改Department信息
	 */
	@Override
	public void updateDepartmentById(Department department) {
		Connection conn=JDBCConn.getConn();
		String sql="update  department set departmentname=?,managerid=? where toid=?";
		PreparedStatement pstmt;
		try {
			pstmt=(PreparedStatement)conn.prepareStatement(sql);
			pstmt.setString(1,department.getDepartmentName());
			pstmt.setInt(2,department.getManagerId());
			pstmt.setInt(3,department.getToId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void updateDepartmentInfo(Department department) {
		// TODO Auto-generated method stub
		
	}
}
