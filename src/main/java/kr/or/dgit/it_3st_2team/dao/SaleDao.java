package kr.or.dgit.it_3st_2team.dao;

import java.util.List;

import kr.or.dgit.it_3st_2team.dto.Sale;

public interface SaleDao {
	int selectMaxSaleNo();
	
	/*selectReportMonth yyj*/
	List<Sale>selectReportMonth();
	
	/*select count test yyj*/
	List<Integer>selectCount();
}
