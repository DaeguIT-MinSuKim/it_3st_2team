package kr.or.dgit.it_3st_2team.dao;

import kr.or.dgit.it_3st_2team.dto.Sale;

public interface SaleDao {
	int selectMaxSaleNo();
	
	int insertSale(Sale sale);
}
