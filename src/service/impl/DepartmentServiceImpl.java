package service.impl;

import java.util.List;

import dao.DepartmentDao;
import dao.impl.DepartmentDaoImpl;
import model.Department;
import service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {
	
	public DepartmentDao departmentDao=new DepartmentDaoImpl();
	
	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public List<Department> findAllDepartment() {
		return departmentDao.findAllDepartment();
	}

	@Override
	public void saveDepartment(Department department) {
		departmentDao.insertDepartment(department);
	}

	@Override
	public void deletDepartmentById(Integer toid) {
		departmentDao.delDepartmentById(toid);
	}

	@Override
	public Department queryDepartmentById(Integer toid) {
		return departmentDao.findDepartmentById(toid);
	}

	@Override
	public void updateDepartmentById(Department department) {
		departmentDao.updateDepartmentById(department);
	}

	@Override
	public void updateDepartmentInfo(Department department) {
		departmentDao.updateDepartmentInfo(department);
	}

}
