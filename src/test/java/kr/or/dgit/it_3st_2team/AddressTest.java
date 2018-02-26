package kr.or.dgit.it_3st_2team;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.it_3st_2team.dto.Address;
import kr.or.dgit.it_3st_2team.dto.Customer;
import kr.or.dgit.it_3st_2team.service.AddressService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddressTest {
	private static AddressService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new AddressService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}
	/*@Test
	public void test1SelectSido() {		
		Address add = new Address();
		add.setSido("대구광역시");	
		Assert.assertNotNull(add);
		System.out.println(add);
	}*/
	/*@Test
	public void test2SelectSigungu() {		
		Address add = new Address();
		add.setSido("대구광역시");
		List<Address> list = service.SelectSigunguSql(add);
		Assert.assertNotNull(add);
		System.out.println(add);
	}*/
	@Test
	public void test3SelectDoro() {		
		Map<String,Object> map = new HashMap<>();	
		map.put("sido", "대구광역시");
		map.put("sigungu", "동구");
		map.put("doro", "율하동%");
		List<Address> list = service.SelectDoro(map);
		Assert.assertNotNull(list);
		for(Address add:list) {
			System.out.println(add);
		}
	}
}
