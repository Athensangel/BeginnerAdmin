package service;

import java.util.List;

import model.Department;

/**
 * 部门DepartmentService类
 * 
 * @author Administrator
 *
 */
public interface DepartmentService {
	public List<Department> findAllDepartment();// 遍历查询Product表中的字段

	public void saveDepartment(Department department);// 新增部门

	public void deletDepartmentById(Integer toid);// 通过toId查找部门信息并做删除处理

	public Department queryDepartmentById(Integer toid);// 通过toId查找部门信息并做删除处理

	public void updateDepartmentById(Department department);// 查找部门，并修改部门信息

	public void updateDepartmentInfo(Department department);// 更改部门信息
}
