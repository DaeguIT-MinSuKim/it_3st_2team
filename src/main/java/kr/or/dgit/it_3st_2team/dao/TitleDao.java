package kr.or.dgit.it_3st_2team.dao;

import java.util.List;

import kr.or.dgit.it_3st_2team.dto.Title;

public interface TitleDao {

	List<Title> selectTitle();

	int insertTitle(Title title);

	int deleteTitle(int row);

	int updateTitle(Title title);

	List<Title> selectTitle2();

}
