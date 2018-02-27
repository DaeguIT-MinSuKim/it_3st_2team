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

/*saleTest생성 yyj 02-27*/
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SaleTest {
	private static SaleService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new SaleService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}
	@Test
	public void test1SelectReportMonth() {
		
        List<Sale> lists = service.selectReportMonth();
        Assert.assertNotNull(lists);
        for(Sale se : lists) {
        	System.out.println(se);
        }

	}
}
