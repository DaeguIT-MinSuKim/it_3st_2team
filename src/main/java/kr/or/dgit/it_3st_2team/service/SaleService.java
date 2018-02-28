package kr.or.dgit.it_3st_2team.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.it_3st_2team.dao.SaleDao;
import kr.or.dgit.it_3st_2team.dto.Sale;
import kr.or.dgit.it_3st_2team.util.MyBatisSqlSessionFactory;

public class SaleService {

	 /*static final추가 yyj02-27*/
	private static final Log log = LogFactory.getLog(SaleService.class);

	private String namespace = "kr.or.dgit.it_3st_2team.dao.SaleDao.";

	
	public int getPresentSaleNo() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			SaleDao saleDao = sqlSession.getMapper(SaleDao.class);
			return saleDao.selectMaxSaleNo();
		}
	}
 /*yyj*/
	public List<Sale>selectReportYear(Map<String,Object> map){
		log.debug("selectReportYear()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			/*SaleDao saleDao = sqlSession.getMapper(SaleDao.class);*/
			return sqlSession.selectList(namespace+"selectReportYear",map);
		}
	}
	public int insertSale(Sale sale) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			int res = sqlSession.insert(namespace+"insertSale", sale);
			sqlSession.commit();
			return res;

		}
	}
	/*yyj*/
	public List<Integer>selectCount(Map<String,Object> map){
		log.debug("selectCount()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+"selectCount",map);
		}
	}
	//khj
	public List<Sale> selectAllSale(){
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+"selectAllSale");
		}
	}

	/*yyj*/
	public List<Integer>selectCountMonth(Map<String,Object> map){
		log.debug("selectCountMonth()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+"selectCountMonth",map);
		}
	}
	//khj 20180228
	public int deleteSale(Sale sale) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			int res = sqlSession.update(namespace+"deleteSale",sale);
			sqlSession.commit();
			return res;

		}
	}
}
