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
		log.debug("selectEmployeeByLoginId()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
			return employeeDao.selectEmpByLoginId(emp);
		}
	}
	
	public List<Employee>selectEmployeeAddTitle(Employee emp){
		log.debug("selectEmployeeAddTitle()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
			return sqlSession.selectList(namespace + "selectTitleName",emp);
		}
		
	}
	public List<Employee> selecteNowEmplyoee() {
		log.debug("selecteNowEmplyoee()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
			return sqlSession.selectList(namespace + "selecteNowEmplyoee");
		}
	}
	
	public List<Employee> insertStudent() {
		log.debug("insertStudent()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
			return sqlSession.selectList(namespace + "insertStudent");
		}
	}
	
	public int selectEmpNo(Employee emp) {
		log.debug("selectEmpNo()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
			return sqlSession.selectOne(namespace + "selectEmpNo",emp);
		}
	}
	
}
