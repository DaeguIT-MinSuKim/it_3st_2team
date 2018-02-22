package kr.or.dgit.it_3st_2team;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.it_3st_2team.dto.Employee;
import kr.or.dgit.it_3st_2team.service.CustomerService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerTest {
	private static CustomerService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new CustomerService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	
	/*
	 	@Test
	 	public void test1SelectAllCustomer() {
		List<Customer> listStd = service.selectAllCustomer();
		Assert.assertNotNull(listStd);
		for (Customer cs : listStd) {
			System.out.println(cs);
		}
	}*/
	/*@Test
	public void test2SelectAllEmp() {
		List<Employee> listStd = service.selectAllEmployee();
		Assert.assertNotNull(listStd);
		for (Employee cs : listStd) {
			System.out.println(cs);
		}
	}*/
}
