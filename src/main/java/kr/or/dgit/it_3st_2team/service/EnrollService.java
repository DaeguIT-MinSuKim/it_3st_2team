package kr.or.dgit.it_3st_2team.service;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.it_3st_2team.dto.Enroll;
import kr.or.dgit.it_3st_2team.util.MyBatisSqlSessionFactory;

public class EnrollService {
	private String namespace = "kr.or.dgit.it_3st_2team.dao.EnrollDao.";
	
	public int insertEnroll(Enroll enroll) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			int res = sqlSession.insert(namespace+"insertEnroll",enroll);
			sqlSession.commit();
			return res;
		}
	}
}
