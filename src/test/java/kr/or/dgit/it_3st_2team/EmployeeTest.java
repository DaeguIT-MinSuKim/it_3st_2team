package kr.or.dgit.it_3st_2team;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import kr.or.dgit.it_3st_2team.service.EmployeeService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeTest {
	private static EmployeeService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new EmployeeService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	/*@Test
	public void test1SelectAllEmployee() {
		List<Employee> listStd = service.selectAllEmployee();
		Assert.assertNotNull(listStd);
		for (Employee cs : listStd) {
			System.out.println(cs);
		}
	}*/
}

