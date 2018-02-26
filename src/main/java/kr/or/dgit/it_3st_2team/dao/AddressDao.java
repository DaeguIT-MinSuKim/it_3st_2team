package kr.or.dgit.it_3st_2team.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.it_3st_2team.dto.Address;

public interface AddressDao {

	/*select sido*/
	List<Address> SelectSidoSql();
	/*select sigungu*/
	List<Address>SelectSigunguSql(Address add);
	
	/*select doro*/
	List<Address>SelectDoro(Map<String,Object> map);
	
}
