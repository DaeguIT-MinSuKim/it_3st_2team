package kr.or.dgit.it_3st_2team.service;


import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.it_3st_2team.dao.EmployeeDao;
import kr.or.dgit.it_3st_2team.dto.Employee;
import kr.or.dgit.it_3st_2team.util.MyBatisSqlSessionFactory;

public class EmployeeService {
	private static final Log log = LogFactory.getLog(EmployeeService.class);
	private String namespace = "kr.or.dgit.it_3st_2team.dao.EmployeeDao.";
	
	public List<Employee> selectAllEmployee() {
		log.debug("selectAllEmployee()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectAllEmployee");
		}
	}
	public Employee selectEmployeeByLoginId(Employee emp) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
			return employeeDao.selectEmpByLoginId(emp);
		}
	}
	
	public List<Employee>selectEmployeeAddTitle(){
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
			return sqlSession.selectList(namespace + "selectTitleName");
		}
		
	}
}
