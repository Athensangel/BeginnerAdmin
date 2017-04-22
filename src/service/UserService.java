package service;

import java.util.List;

import model.User;

public interface UserService {
	public User checkUserLogin(String username,String password);//登陆验证
	
	
	public List<User> findAllUsers();//遍历查询User表中的字段
	
	public void  saveUser(User user);//新增员工
	
	public void deletUserById(Integer toid);//通过toId查找员工信息并做删除处理

	public User queryUserById(Integer toid);// 通过toId查找员工信息并做删除处理
	
	public void  updateUserByID(User user);//查找员工，并修改员工信息
	
	public void updateUserInfo(User user);//更改员工信息
}
