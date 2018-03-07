package kr.or.dgit.it_3st_2team;




import java.text.SimpleDateFormat;
import java.util.Date;
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
		}*/


	



/*	@Test

	public void test4DeleteSale() {
		Sale sale = new Sale(28);
		service.deleteSale(sale);
	}*/

	
	/*@Test
	public void test5UpdateSale() {
		Customer customer = new Customer(1);
		Employee employee = new Employee(1);
		Event event = new Event(1);
		Sale sale = new Sale(37, customer, employee, event, 1);
		service.updateSale(sale);
	}*/
	
	/*@Test
	public void test6SelectSaleByCusName() {
		Customer customer = new Customer(1);
		Sale sale = new Sale(customer);
		service.selectSaleByCusNo(sale);
		
	}*/
	
	/*@Test
	public void test6SelectSaleByDate() {
		String from = "2017-01-01";
		String to = "2017-12-31";
		service.selectSaleByDate(from, to);
	}*/
	
	/*@Test
	public void test7SelectSaleByCusNoAndDate(){
		String cusName ="이연재";
		String from = "2017-01-01";
		String to = "2017-12-31";
		service.selectSaleByCusNoAndDate(cusName, from, to);
	}
*/
	/*@Test
	public void test6SelectYear() {
		
	    List<String> lists = service.selectYearExist();
	    Assert.assertNotNull(lists);
	    for(String se : lists) {
	    	System.out.println(se);
	    	}
		}
*/
	@Test
	public void test7SelectMonthlyChart() {
		Map<String,String> map = new HashMap<>();	
		map.put("xx","2018%");
		List<Sale> lists = service.selectMonthlyChart(map);
	}
}
