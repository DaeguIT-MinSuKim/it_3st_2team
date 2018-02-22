package kr.or.dgit.it_3st_2team.dao;

import java.util.List;
import kr.or.dgit.it_3st_2team.dto.Employee;

public interface EmployeeDao {
	List<Employee> selectAllEmployee();
	Employee selectEmpByLoginId(Employee id);
}
