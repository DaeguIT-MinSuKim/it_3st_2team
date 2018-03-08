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


	public List<Employee> selectEmployeeByLoginId() {
		log.debug("selectEmployeeByLoginId()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+"selectEmployeeByLoginId");
		}
	}

	public List<Employee> selectEmployeeAddTitle(Employee emp) {
		log.debug("selectEmployeeAddTitle()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
			return sqlSession.selectList(namespace + "selectTitleName", emp);
		}

	}

	public List<Employee> selecteNowEmplyoee() {
		log.debug("selecteNowEmplyoee()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
			return sqlSession.selectList(namespace + "selecteNowEmplyoee");
		}
	}

	public int selectEmpNo(Employee emp) {
		log.debug("selectEmpNo()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
			return sqlSession.selectOne(namespace + "selectEmpNo", emp);
		}
	}

	public int updateNowEmplyoee(Employee employee) {
		log.debug("updateNowEmplyoee()");
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
			res = employeeDao.updateNowEmplyoee(namespace + "updateNowEmplyoee",employee);
			sqlSession.commit();
		}
		return res;
	}

	public int EmployeeSizeNo() {
		log.debug("EmployeeSizeNo()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			sqlSession.commit();
			
			return sqlSession.selectOne(namespace + "EmployeeSizeNo");

		}
	}

	
	public List<Employee> selectemployeeoff() {
		log.debug("selectemployeeoff()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			EmployeeDao EmployeeDao = sqlSession.getMapper(EmployeeDao.class);
			sqlSession.commit();
			return EmployeeDao.selectemployeeoff();
		}
	}
	/*yyj 03-07*/
	public List<Employee>selectEmpEmpPerformance(){
		log.debug("selectEmpEmpPerformance()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectEmpEmpPerformance");
		}
	}
	/*yyj 03-07*/
	public int SelectEmpPrice(Employee emp) {
		log.debug("SelectEmpPrice()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "SelectEmpPrice",emp);
		}
	}
}
