package kr.or.dgit.it_3st_2team.dao;

import kr.or.dgit.it_3st_2team.dto.Employee;

public interface EmployeeDao {
	Employee selectEmpByLoginId(Employee id);
}
