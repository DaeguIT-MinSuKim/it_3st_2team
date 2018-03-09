package kr.or.dgit.it_3st_2team;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.it_3st_2team.dto.Employee;
import kr.or.dgit.it_3st_2team.dto.Title;
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

	/*
	 * @Test public void test1SelectAllEmployee() { List<Employee> listStd =
	 * service.selectAllEmployee(); Assert.assertNotNull(listStd); for (Employee cs
	 * : listStd) { System.out.println(cs); } }
	 */

	/*
	 * @Test public void selectTitleName(){ List<Employee> listStd =
	 * service.selectEmployeeAddTitle(); Assert.assertNotNull(listStd); for
	 * (Employee cs : listStd) { System.out.println(cs); } }
	 */

	/*
	 * @Test public void test2SelectempNo() { Employee emp = new Employee("이창준");
	 * int no = service.selectEmpNo(emp); }
	 */

	/*
	 * @Test public void test3SelectEmployeeByLoginId() { List<Employee> list = new
	 * ArrayList<>(); list = service.selectEmployeeByLoginId(); String testId =
	 * "idmaster"; boolean b = false; for(Employee e: list) {
	 * if(e.getId().equals(testId)) { b = true;
	 * System.out.println("직급:"+e.getTitle().getTitleName()); } } if(b!=true) {
	 * System.out.println("존재하지 않은 아이디입니다. 회원가입 해주세요"); } }
	 */
	/*
	 * @Test public void test4InsertEmployee() { Calendar calender =
	 * GregorianCalendar.getInstance(); calender.set(2018, 12 - 1, 01); Title title
	 * = new Title(2); Employee employee = new Employee(13, "test",
	 * calender.getTime(),null, "id", "pw",title,0, true);
	 * 
	 * int re =service.insertEmployee(employee); assertEquals(1, re); }
	 */

	/*
	 * @Test public void test1SelectAllEmployee() { List<Employee> listStd =
	 * service.selectAllEmployee(); Assert.assertNotNull(listStd); for (Employee cs
	 * : listStd) { System.out.println(cs); } }
	 */

	/*
	 * @Test public void selectTitleName(){ List<Employee> listStd =
	 * service.selectEmployeeAddTitle(); Assert.assertNotNull(listStd); for
	 * (Employee cs : listStd) { System.out.println(cs); } }
	 */

	/*
	 * @Test public void test2SelectempNo() { Employee emp = new Employee("이창준");
	 * int no = service.selectEmpNo(emp); }
	 */

	@Test
	public void test3SelectEmployeeByLoginId() {
		List<Employee> list = new ArrayList<>();
		list = service.selectEmployeeByLoginId();
		String testId = "idmaster";
		boolean b = false;
		for (Employee e : list) {
			if (e.getId().equals(testId)) {
				b = true;
				System.out.println("직급:" + e.getTitle().getTitleName());
			}
		}
		if (b != true) {
			System.out.println("존재하지 않은 아이디입니다. 회원가입 해주세요");
		}
	}

	/*@Test
	public void test4SelectEmpEmpPerformance() {
		List<Employee> list = new ArrayList<>();
		list = service.selectEmpEmpPerformance();
		for (Employee e : list) {
			Employee ee = new Employee();
			ee.setEmpNo(e.getEmpNo());
			int p = service.SelectEmpPrice(ee);
			System.out.println(p);
		}
	}*/
}
