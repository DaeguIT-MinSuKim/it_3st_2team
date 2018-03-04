package kr.or.dgit.it_3st_2team;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.it_3st_2team.dto.Enroll;
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
	
	/*@Test
	public void test2DeleteEnroll() {
		Enroll enroll = new Enroll(8);
		service.deleteEnroll(enroll);
	}*/
	
	@Test
	public void test3SelectEnrollBySaleNo() {
		Enroll enroll = new Enroll(16);
		service.selectEnrollBySaleNo(enroll);
	}
	
	@Test
	public void test4UpdateEnrollofHair() {
		Enroll enroll = new Enroll(16, 1);
		service.updateEnrollofHair(enroll);
		
	}
}
