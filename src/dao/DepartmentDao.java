package dao;

import java.util.List;

import model.Department;

public interface DepartmentDao {

	List<Department> findAllDepartment();//查找Department实体类的所有信息

	void insertDepartment(Department department);//添加一条记录给Department表

	void delDepartmentById(Integer toid);//通过toId删除一条记录

	Department findDepartmentById(Integer toid);//通过toId找到一条记录

	void updateDepartmentById(Department department);//修改找到一条记录

	void updateDepartmentInfo(Department department);//修改找到一条记录

}
