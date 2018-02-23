package kr.or.dgit.it_3st_2team.dao;

import java.util.List;

import kr.or.dgit.it_3st_2team.dto.Event;

public interface EventDao {
	List<Event> selectAllEvent();
}
