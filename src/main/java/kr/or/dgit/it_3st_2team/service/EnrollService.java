package kr.or.dgit.it_3st_2team.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.it_3st_2team.dto.Enroll;
import kr.or.dgit.it_3st_2team.dto.Hair;
import kr.or.dgit.it_3st_2team.dto.Sale;
import kr.or.dgit.it_3st_2team.util.MyBatisSqlSessionFactory;

public class EnrollService {
	private String namespace = "kr.or.dgit.it_3st_2team.dao.EnrollDao.";
	private static final Log log = LogFactory.getLog(EnrollService.class);
	
	public int insertEnroll(Enroll enroll) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			int res = sqlSession.insert(namespace+"insertEnroll",enroll);
			sqlSession.commit();
			return res;
		}
	}
	public int deleteEnroll(Enroll enroll) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			int res = sqlSession.update(namespace+"deleteEnroll",enroll);
			sqlSession.commit();
			return res;
		}
	}
	/*public int updateEnroll(Enroll enroll) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			int res = sqlSession.update(namespace,enroll);
			sqlSession.commit();
			return res;
		}
	}*/
	public List<Enroll> selectEnrollBySaleNo(Enroll enroll) {
		log.debug("selectEnrollBySaleNo()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+"selectEnrollBySaleNo",enroll);
		}
	}
	public int updateEnrollofHair(Enroll enroll) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			int res = sqlSession.update(namespace+"updateEnrollofHair",enroll);
			sqlSession.commit();
			return res;
		}
	}
	public List<Enroll> selectChart(){
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace+"selectChart");
		}
	}
	public int selectChartCount(int hairNo) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			int res= sqlSession.selectOne(namespace+"selectChartCount",hairNo);
			return res;
		}
	}
}
