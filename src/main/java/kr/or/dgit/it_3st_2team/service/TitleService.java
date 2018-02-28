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
		log.debug("selectAllTitle()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			TitleDao TitleDao = sqlSession.getMapper(TitleDao.class);
			return TitleDao.selectTitle();
		}

	}

	public int insertTitle(Title title) {
		log.debug("insertTitle()");
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			TitleDao TitleDao = sqlSession.getMapper(TitleDao.class);
			res = TitleDao.insertTitle(title);
			sqlSession.commit();
		}
		return res;
	}

	public int deleteTitle(int row) {
		log.debug("deleteTitle()");
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			TitleDao TitleDao = sqlSession.getMapper(TitleDao.class);
			res = TitleDao.deleteTitle(row);
			sqlSession.commit();
		}
		return res;
	}

	public int updateTitle(Title title) {
		log.debug("updateTitle()");
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			TitleDao TitleDao = sqlSession.getMapper(TitleDao.class);
			res = TitleDao.updateTitle(title);
			sqlSession.commit();
		}
		return res;

	}

}