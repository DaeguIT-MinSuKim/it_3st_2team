package kr.or.dgit.it_3st_2team.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.it_3st_2team.dto.Hair;
import kr.or.dgit.it_3st_2team.util.MyBatisSqlSessionFactory;

public class HairService {
	private String namespace = "kr.or.dgit.it_3st_2team.dao.HairDao.";
	
	public List<Hair> SelectAllHair(){
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+"selectAllHair");
		}
	}
}
