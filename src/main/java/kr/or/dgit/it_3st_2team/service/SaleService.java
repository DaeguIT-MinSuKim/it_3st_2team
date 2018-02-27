package kr.or.dgit.it_3st_2team.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.it_3st_2team.dao.SaleDao;
import kr.or.dgit.it_3st_2team.dto.Customer;
import kr.or.dgit.it_3st_2team.dto.Employee;
import kr.or.dgit.it_3st_2team.dto.Event;
import kr.or.dgit.it_3st_2team.dto.Sale;
import kr.or.dgit.it_3st_2team.util.MyBatisSqlSessionFactory;

public class SaleService {
	private String namespace = "kr.or.dgit.it_3st_2team.dao.SaleDao.";
	
	
	public int getPresentSaleNo() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			SaleDao saleDao = sqlSession.getMapper(SaleDao.class);
			return saleDao.selectMaxSaleNo();
		}
	}
	
	public int insertSale(Sale sale) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			int res = sqlSession.insert(namespace+"insertSale", sale);
			sqlSession.commit();
			return res;
		}
	}
	
	public List<Sale> selectAllSale(){
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+"selectAllSale");
		}
	}
}
