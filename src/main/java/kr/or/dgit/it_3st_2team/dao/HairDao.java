package kr.or.dgit.it_3st_2team.dao;

import java.util.List;

import kr.or.dgit.it_3st_2team.dto.Hair;

public interface HairDao {
	List<Hair> selectAllHair();

	int insertHair(Hair hair);

	int deleteHair(int hno);

	int updateHair(Hair hair);
}
