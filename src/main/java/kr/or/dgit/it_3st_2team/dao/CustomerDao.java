package kr.or.dgit.it_3st_2team.dao;

import java.util.List;
import kr.or.dgit.it_3st_2team.dto.Customer;

public interface CustomerDao {
	List<Customer> selectAllCustomer();
}
