package kr.or.dgit.it_3st_2team;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.it_3st_2team.dto.Title;
import kr.or.dgit.it_3st_2team.service.TitleService;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TitleTest {

	private static TitleService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new TitleService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}
	
	/*@Test
	public void test1insertTitle() {
		Title Title = new Title(5,"인턴");
		int res = service.insertTitle(Title);
		Assert.assertNotNull(Title);
		
	}*/
	
	
	
}
