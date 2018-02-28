package kr.or.dgit.it_3st_2team.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.it_3st_2team.dao.EventDao;

import kr.or.dgit.it_3st_2team.dto.Event;
import kr.or.dgit.it_3st_2team.util.MyBatisSqlSessionFactory;

public class EventService {
	private String namespace = "kr.or.dgit.it_3st_2team.dao.EventDao.";

	public List<Event> selectAllEvent() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectAllEvent");
		}
	}

	public int insertEvent(Event event) {
	
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			EventDao EventDao = sqlSession.getMapper(EventDao.class);
			res = EventDao.insertEvent(event);
			sqlSession.commit();
		}
		return res;
	}

	public int deleteEvent(int eno) {
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			EventDao EventDao = sqlSession.getMapper(EventDao.class);
			res = EventDao.deleteEvent(eno);
			sqlSession.commit();
		}
		return res;
	}

	public int UpdateEvent(Event event) {
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			EventDao EventDao = sqlSession.getMapper(EventDao.class);
			res = EventDao.UpdateEvent(event);
			sqlSession.commit();
		}
		return res;
	}
}
