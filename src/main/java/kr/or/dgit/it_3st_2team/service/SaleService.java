package kr.or.dgit.it_3st_2team.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.it_3st_2team.dao.SaleDao;
import kr.or.dgit.it_3st_2team.dto.Sale;
import kr.or.dgit.it_3st_2team.util.MyBatisSqlSessionFactory;

public class SaleService {
	 /*static final추가 yyj02-27*/
	private static final Log log = LogFactory.getLog(SaleService.class);
	
	
	public int getPresentSaleNo() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			SaleDao saleDao = sqlSession.getMapper(SaleDao.class);
			return saleDao.selectMaxSaleNo();
		}
	}
	public List<Sale>selectReportMonth(){
		log.debug("selectReportMonth()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			SaleDao saleDao = sqlSession.getMapper(SaleDao.class);
			return saleDao.selectReportMonth();
		}
	}
}
