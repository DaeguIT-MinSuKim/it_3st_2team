package kr.or.dgit.it_3st_2team.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.it_3st_2team.dao.TitleDao;
import kr.or.dgit.it_3st_2team.dto.Title;
import kr.or.dgit.it_3st_2team.util.MyBatisSqlSessionFactory;

public class TitleService {
	private static final Log log = LogFactory.getLog(TitleService.class);

	public List<Title> selectAllTitle() {
		log.debug("TitleService()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			 TitleDao TitleDao = sqlSession.getMapper(TitleDao.class);
			return TitleDao.selectTitle();
		}

	}
	public List<Title> insertTitle() {
		log.debug("insertTitle()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			 TitleDao TitleDao = sqlSession.getMapper(TitleDao.class);
			return TitleDao.selectTitle();
		}

	}
	public int insertTitle(Title title) {
		log.debug("insertTitle()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			 TitleDao TitleDao = sqlSession.getMapper(TitleDao.class);
			return TitleDao.insertTitle();
		}
	}

}
