package kr.or.dgit.it_3st_2team;



import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

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
	
	/*@Test
	public void test2SelectAllSale() {
		service.selectAllSale();
	}*/
	
/*	@Test
	public void test2SelectReportMonth() {
		
		
		Map<String,Object> map = new HashMap<>();	
		//map.put("sDate","%-01-%");
        List<Sale> lists = service.selectReportYear(map);
        Assert.assertNotNull(lists);
        for(Sale se : lists) {
        	System.out.println(se);
        }
}*/



	/*@Test

	public void test3SelectCount() {
		Map<String,Object> map = new HashMap<>();	
		map.put("sDate","2017%");
	    List<Integer> lists = service.selectCount(map);
	    Assert.assertNotNull(lists);
	    for(Integer se : lists) {
	    	System.out.println(se);
	    	}

		}*/
/*	@Test
	public void test4SelectCountMonth() {
		Map<String,Object> map = new HashMap<>();	
		map.put("sDate","%-01-%");
	    List<Integer> lists = service.selectCountMonth(map);
	    Assert.assertNotNull(lists);
	    for(Integer se : lists) {
	    	System.out.println(se);
	    	}
		}
*/

	
	@Test
	public void test4DeleteSale() {
		Sale sale = new Sale(28);
		service.deleteSale(sale);
	}
}
