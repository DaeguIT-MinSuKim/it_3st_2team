package kr.or.dgit.it_3st_2team.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.it_3st_2team.dto.Event;
import kr.or.dgit.it_3st_2team.util.MyBatisSqlSessionFactory;

public class EventService {
	private String namespace = "kr.or.dgit.it_3st_2team.dao.EventDao.";
	
	public List<Event> selectAllEvent(){
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace + "selectAllEvent");
		}
	}
}
