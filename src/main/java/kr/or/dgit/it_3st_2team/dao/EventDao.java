package kr.or.dgit.it_3st_2team.dao;

import java.util.List;

import kr.or.dgit.it_3st_2team.dto.Event;

public interface EventDao {
	List<Event> selectAllEvent();

	int insertEvent(Event event);

	int deleteEvent(int eno);

	int UpdateEvent(Event event);
}
