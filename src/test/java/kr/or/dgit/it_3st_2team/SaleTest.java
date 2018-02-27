package kr.or.dgit.it_3st_2team;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.it_3st_2team.dto.Customer;
import kr.or.dgit.it_3st_2team.dto.Employee;
import kr.or.dgit.it_3st_2team.dto.Event;
import kr.or.dgit.it_3st_2team.dto.Sale;
import kr.or.dgit.it_3st_2team.service.SaleService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SaleTest {
	private static SaleService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		service = new SaleService();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		service = null;
	}
	
/*	@Test
	public void test1InsertSale() {
		Customer customer = new Customer(1);
		Employee employee = new Employee(1);
		Event event = new Event(1);
		Calendar jDate = GregorianCalendar.getInstance();
		int jdyear = 2018;
		int jdmonth = 03;
		int jdday = 01;
		jDate.set(jdyear, jdmonth - 1, jdday);
		Sale sale = new Sale(20,jDate.getTime(), jDate.getTime() ,customer, employee, event, 1000);
		service.insertSale(sale);
	
	}*/
	
	@Test
	public void test2SelectAllSale() {
		service.selectAllSale();
	}
}
