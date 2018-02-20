package kr.or.dgit.it_3st_2team.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.it_3st_2team.dto.Customer;
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
	
}
