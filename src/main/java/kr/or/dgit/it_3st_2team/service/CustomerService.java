package kr.or.dgit.it_3st_2team.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.it_3st_2team.dto.Customer;
import kr.or.dgit.it_3st_2team.dto.Employee;
import kr.or.dgit.it_3st_2team.util.MyBatisSqlSessionFactory;




public class CustomerService {
	private static final Log log = LogFactory.getLog(CustomerService.class);
	private String namespace = "kr.or.dgit.it_3st_2team.dao.CustomerDao.";
	
	
	
	public List<Customer> selectAllCustomer() {
		log.debug("selectAllCustomer()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectAllCustomer");
		}
	}
	public List<Employee> selectAllEmployee(){
		log.debug("selectAllEmployee()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectAllEmployee");
		}
	}
	
	public List<Customer> SelectAllCustomerEmpName(Customer customer){
		log.debug("SelectAllCustomerEmpName()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "SelectAllCustomerEmpName",customer);
		}
	}
	public int inSertCustomer(Customer customer) {
		log.debug("inSertCustomer()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.insert(namespace + "inSertCustomer",customer);
			sqlSession.commit();
			return res;
		}
	}
	public List<Customer>SelectWhereCusId(Customer customer){
		log.debug("SelectWhereCusId()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "SelectWhereCusId",customer);
		}
	}
	public int  cusomerSizeNo() {
		log.debug("cusomerSizeNo()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "cusomerSizeNo");
		}
	}
}
