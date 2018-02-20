package kr.or.dgit.it_3st_2team.service;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.it_3st_2team.dao.EmployeeDao;
import kr.or.dgit.it_3st_2team.dto.Employee;
import kr.or.dgit.it_3st_2team.util.MyBatisSqlSessionFactory;

public class EmployeeService {
	public Employee selectEmployeeByLoginId(Employee emp) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
			return employeeDao.selectEmpByLoginId(emp);
		}
	}
}
