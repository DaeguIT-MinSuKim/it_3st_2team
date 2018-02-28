package kr.or.dgit.it_3st_2team.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.it_3st_2team.dao.HairDao;
import kr.or.dgit.it_3st_2team.dao.TitleDao;
import kr.or.dgit.it_3st_2team.dto.Hair;
import kr.or.dgit.it_3st_2team.dto.Title;
import kr.or.dgit.it_3st_2team.util.MyBatisSqlSessionFactory;

public class HairService {
	private String namespace = "kr.or.dgit.it_3st_2team.dao.HairDao.";

	private static final Log log = LogFactory.getLog(HairService.class);

	public List<Hair> SelectAllHair() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			HairDao HairDao = sqlSession.getMapper(HairDao.class);
			return HairDao.selectAllHair();
		}
	}

	public int insertHair(Hair hair) {
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			HairDao HairDao = sqlSession.getMapper(HairDao.class);
			res = HairDao.insertHair(hair);
			sqlSession.commit();
		}
		return res;

	}

	public int deleteHair(int hno) {
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			HairDao HairDao = sqlSession.getMapper(HairDao.class);
			res = HairDao.deleteHair(hno);
			sqlSession.commit();
		}
		return res;
	}

	public int updateHair(Hair hair) {
		log.debug("updateHair()");
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			HairDao HairDao = sqlSession.getMapper(HairDao.class);
			res = HairDao.updateHair(hair);
			sqlSession.commit();
		}
		return res;
	}
}
