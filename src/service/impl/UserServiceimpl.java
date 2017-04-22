package service.impl;

import java.util.List;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;
import service.UserService;

public class UserServiceimpl implements UserService {
	public UserDao userDao=new UserDaoImpl();

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public User checkUserLogin(String username, String password) {
		return userDao.checkLogin(username, password);
	}

	@Override
	public List<User> findAllUsers() {
		return userDao.findAllUsers();	//查找所有员工的信息
	}
	/**
	 * 添加员工信息
	 */
	@Override
	public void saveUser(User user) {
		userDao.insertUser(user);
	}
	/**
	 * 删除员工信息
	 */
	@Override
	public void deletUserById(Integer toid) {
		userDao.delUserById(toid);
	}
	/**
	 * 通过ID来查询员工信息
	 */
	@Override
	public User queryUserById(Integer toid) {
		return userDao.findUserById(toid);
	}
	/**
	 * 修改员工信息
	 */
	@Override
	public void updateUserByID(User user) {
		userDao.updateUserById(user);
	}
	/**
	 * 修改员工信息
	 */
	@Override
	public void updateUserInfo(User user) {
		userDao.updateUserInfo(user);
	}
}
