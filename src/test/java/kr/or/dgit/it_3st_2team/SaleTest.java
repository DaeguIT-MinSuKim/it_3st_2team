package kr.or.dgit.it_3st_2team;



import java.util.List;

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
/*	@Test
	public void test2SelectReportMonth() {
		
        List<Sale> lists = service.selectReportMonth();
        Assert.assertNotNull(lists);
        for(Sale se : lists) {
        	System.out.println(se);
        }
}*/
@Test
public void test3SelectCount() {
	
    List<Integer> lists = service.selectCount();
    Assert.assertNotNull(lists);
    for(Integer se : lists) {
    	System.out.println(se);
    }
}
}
