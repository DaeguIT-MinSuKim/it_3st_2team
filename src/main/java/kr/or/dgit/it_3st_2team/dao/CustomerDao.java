package kr.or.dgit.it_3st_2team.dao;

import java.util.List;
import kr.or.dgit.it_3st_2team.dto.Customer;
import kr.or.dgit.it_3st_2team.dto.Employee;

public interface CustomerDao {
	List<Customer> selectAllCustomer();
	List<Employee> selectAllEmployee();
	/*select customerAll*/
	List<Customer> SelectAllCustomerEmpName(Customer customer);
	
	/*select customername*/
	List<Customer> SelectAllCustomerName(Customer customer);
	/*insert customer*/
	int inSertCustomer(Customer customer);
	
	List<Customer>SelectWhereCusId(Customer customer);
	
	/*select CusomerSize*/
	int cusomerSizeNo();
	
	/*update customer*/
	int updateSetCustomer(Customer customer);
	/*delete customer*/
	int deleteCustomer(Customer customer);
}
