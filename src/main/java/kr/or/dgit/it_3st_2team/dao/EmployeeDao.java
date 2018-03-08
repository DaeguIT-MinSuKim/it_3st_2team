package kr.or.dgit.it_3st_2team.dao;

import java.util.List;

import kr.or.dgit.it_3st_2team.dto.Employee;

public interface EmployeeDao {
	List<Employee> selectAllEmployee();

	// Employee selectEmpByLoginId(Employee id);

	List<Employee> selecteNowEmplyoee();

	List<Employee> selectTitleName(Employee emp);

	List<Employee> insertStudent();

	int selectEmpNo(Employee emp);

	int EmployeeSizeNo();

	List<Employee> selectemployeeoff();


	List<Employee> selectEmployeeByid(String string);

	int insertEmployee(Employee emp);

	int updateNowEmployee(Employee emp);
	

	
}
