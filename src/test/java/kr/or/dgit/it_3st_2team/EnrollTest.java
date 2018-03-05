package kr.or.dgit.it_3st_2team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.it_3st_2team.dto.Enroll;
import kr.or.dgit.it_3st_2team.dto.Hair;
import kr.or.dgit.it_3st_2team.dto.Sale;
import kr.or.dgit.it_3st_2team.service.EnrollService;
import kr.or.dgit.it_3st_2team.service.HairService;

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
	
	/*@Test
	public void test3SelectEnrollBySaleNo() {
		Enroll enroll = new Enroll(16);
		service.selectEnrollBySaleNo(enroll);
	}
	
	@Test
	public void test4UpdateEnrollofHair() {
		Enroll enroll = new Enroll(16, 1);
		service.updateEnrollofHair(enroll);	
	}*/
	
	@Test
	public void test5Chart() {
		List<Enroll> list = service.selectChart();
		List<String> hairNos = new ArrayList<>();
		//Map<Integer, String> hairNoName = new HashMap<>();
		for(Enroll e: list) {
			//System.out.println(e.getHairNo());
			hairNos.add(Integer.toString(e.getHairNo()));
			//hairNoName.put(e.getHairNo(), e.getHair().getHairName());
		}
		//System.out.println(hairNos);
		
		//Map<String, Integer> map = new HashMap<>();
		int num = -1;
		for(String str:hairNos) {
			//System.out.println(str);
			num = service.selectChartCount(Integer.parseInt(str));
			System.out.println(str+":"+num);
			//map.put(str, num);
		}
	}
	
}
