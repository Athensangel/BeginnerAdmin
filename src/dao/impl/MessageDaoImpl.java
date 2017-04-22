package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MessageDao;
import model.Message;
import until.JDBCConn;
/**
 * MessageDaoImpl的实现类
 * @author Administrator
 *
 */
public class MessageDaoImpl implements MessageDao {

	@Override
	public List<Message> findAllMessage() {
		/**
		 * 查询Message表中的所有信息
		 */
		Connection conn=JDBCConn.getConn();
		List<Message> MessageList=new ArrayList<Message>();
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("SELECT a.id,a.content,b.realname realNameFrom,c.realname realNameTo,");
		stringBuffer.append("CASE WHEN a.isread = '0' THEN '未读' WHEN a.isread = '1' THEN '已读'  ELSE '其他' END   isRead ");
		stringBuffer.append("FROM message a ");
		stringBuffer.append("LEFT JOIN `user` b on b.toid = a.from_id ");
		stringBuffer.append("LEFT JOIN `user` c on c.toid = a.to_id; ");
		PreparedStatement pstmt;
		try {
			pstmt=(PreparedStatement)conn.prepareStatement(stringBuffer.toString());
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				Message message=new Message();
				message.setId(rs.getInt(1));
				message.setContent(rs.getString(2));
				message.setRealNameFrom(rs.getString(3));
				message.setRealNameTo(rs.getString(4));
				message.setIsRead(rs.getString(5));
				MessageList.add(message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return MessageList;
		}
	/**
	 * 添加产品信息
	 */
	@Override
	public void InsertMessage(Message message) {
		Connection conn=JDBCConn.getConn();
		String sql="insert into message(from_id,to_id,content,isread) values(?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt=(PreparedStatement)conn.prepareStatement(sql);
			pstmt.setInt(1,message.getFromId());
			pstmt.setInt(2,message.getToId());
			pstmt.setString(3,message.getContent());
			pstmt.setString(4,message.getIsRead());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 删除数据
	 */
	@Override
	public void delMessageById(Integer id) {
		Connection conn=JDBCConn.getConn();
		String sql="delete from message where id=?";
		PreparedStatement pstmt;
		try {
			pstmt=(PreparedStatement)conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * toId更新数据
	 */
	@Override
	public Message findMessageById(Integer id) {
		Connection conn=JDBCConn.getConn();
		Message message=new Message();
		String sql="select * from message where id=?";
		PreparedStatement pstmt;
		try {
			pstmt=(PreparedStatement)conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				message.setId(rs.getInt(1));;
				message.setFromId(rs.getInt(2));;
				message.setToId(rs.getInt(3));;
				message.setContent(rs.getString(4));;
				message.setIsRead(rs.getString(5));;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return message;
	}
	@Override
	public void updateMessageById(Message message) {
		Connection conn=JDBCConn.getConn();
		String sql="update message set from_id=?,to_id=?,content=?,isread=? where id=?";
		PreparedStatement pstmt;
		try {
			pstmt=(PreparedStatement)conn.prepareStatement(sql);
			pstmt.setInt(1, message.getFromId());
			pstmt.setInt(2, message.getToId());
			pstmt.setString(3,message.getContent());
			pstmt.setString(4,message.getIsRead());
			pstmt.setInt(5, message.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void updateMessageInfo(Message message) {
		// TODO Auto-generated method stub
		
	}
	
}
