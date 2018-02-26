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

	/*@Test
<<<<<<< HEAD
	public void test1SelectAllEmployee() {
		List<Employee> listStd = service.selectAllEmployee();
		Assert.assertNotNull(listStd);
		for (Employee cs : listStd) {
			System.out.println(cs);
		}

=======
	public void selectTitleName() {
		
		  @Test 
		  public void test1SelectAllEmployee() 
		  { List<Employee> listStd =
		  service.selectAllEmployee(); Assert.assertNotNull(listStd); for (Employee cs
		  : listStd) { System.out.println(cs); } }
		 
		
		  @Test public void selectTitleName(){  List<Employee> listStd =
		  service.selectEmployeeAddTitle(); Assert.assertNotNull(listStd); for
		  (Employee cs : listStd) { System.out.println(cs); } }
		 
>>>>>>> refs/remotes/origin/master
	}*/
<<<<<<< HEAD

=======
	 @Test 
	 public void test2SelectempNo() {
		 Employee emp = new Employee("이창준");
		 int no = service.selectEmpNo(emp);
	 }
>>>>>>> refs/remotes/origin/master
}
