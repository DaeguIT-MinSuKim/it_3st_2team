package kr.or.dgit.it_3st_2team.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.it_3st_2team.dto.Address;
import kr.or.dgit.it_3st_2team.util.MyBatisSqlSessionFactory;

public class AddressService {
	private static final Log log = LogFactory.getLog(AddressService.class);
	private String namespace = "kr.or.dgit.it_3st_2team.dao.AddressDao.";
	
	
	
	public List<Address> SelectSidoSql() {
		log.debug("SelectSidoSql()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "SelectSidoSql");
		}
	}
	public List<Address>SelectSigunguSql(Address add){
		log.debug("SelectSigunguSql()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "SelectSigunguSql",add);
		}
	}
	public List<Address>SelectDoro(Map<String,Object> map){
		log.debug("SelectDoro()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "SelectDoro",map);
		}
	}
}
