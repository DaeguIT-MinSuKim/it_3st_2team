package kr.or.dgit.it_3st_2team;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.it_3st_2team.dto.Enroll;
import kr.or.dgit.it_3st_2team.dto.Hair;
import kr.or.dgit.it_3st_2team.dto.Sale;
import kr.or.dgit.it_3st_2team.service.EnrollService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EnrollTest {
	private static EnrollService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		service = new EnrollService();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		service = null;
	}
	
	/*@Test
	public void test1InsertEnroll() {
		Enroll enroll = new Enroll(26, 17, 1);
		service.insertEnroll(enroll);
	}*/
}
