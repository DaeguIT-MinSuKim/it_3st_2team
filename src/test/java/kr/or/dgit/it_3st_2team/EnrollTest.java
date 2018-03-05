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
		List<Hair> hlist = new ArrayList<>();
		for(Enroll e:list) {
			hlist.add(new Hair(e.getHairNo(), e.getHair().getHairName()));
		}
		int num = -1;
		Map<String,Integer> hmap = new HashMap<>();
		for(Hair h:hlist) {
			num = service.selectChartCount(h.getHairNo());
			hmap.put(h.getHairName(), num);
		}
		for(String key:hmap.keySet()) {
			int value = hmap.get(key);
			System.out.println(key+":"+value);
		}
	}
	
}
