package kr.or.dgit.it_3st_2team;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.it_3st_2team.dto.Employee;
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

	@Test
	public void test1SelectAllEmployee() {
		List<Employee> listStd = service.selectAllEmployee();
		Assert.assertNotNull(listStd);
		for (Employee cs : listStd) {
			System.out.println(cs);
		}
	}
	
	@Test
	public void test2selectEmpByLoginId() {
		Employee employee = new Employee();
		employee.setId("idemp1");
		employee.setPassword("pwemp1");
		Employee searchEmployee = service.selectEmployeeByLoginId(employee);
		if (employee.getPassword().equals(searchEmployee.getPassword())) {
			System.out.println("로그인 성공");

		}else {
			System.out.println("비밀번호가 틀렸습니다");
		}
	}
	
}
