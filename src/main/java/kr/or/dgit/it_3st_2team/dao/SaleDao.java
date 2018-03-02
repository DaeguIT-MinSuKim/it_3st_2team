package kr.or.dgit.it_3st_2team.dao;


import java.util.List;
import java.util.Map;

import kr.or.dgit.it_3st_2team.dto.Sale;

public interface SaleDao {
	int selectMaxSaleNo();
	

	int insertSale(Sale sale);

	/*selectReportMonth yyj*/
	List<Sale>selectReportYear(Map<String,Object> map);
	
	/*selectReportAll yyj*/
	List<Sale>selectReportAll();
	
	/*select count test yyj*/
	List<Integer>selectCount(Map<String,Object> map);
	List<Integer>selectCountMonth(Map<String,Object> map);
	List<Integer>SelectAllCount();
	
	/*select year yyj*/
	List<String>selectYearExist();
}
