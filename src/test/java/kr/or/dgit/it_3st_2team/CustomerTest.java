package kr.or.dgit.it_3st_2team;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.it_3st_2team.dto.Customer;
import kr.or.dgit.it_3st_2team.dto.Employee;
import kr.or.dgit.it_3st_2team.dto.PhoneNumber;
import kr.or.dgit.it_3st_2team.service.CustomerService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerTest {
	private static CustomerService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new CustomerService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	/*@Test
	public void test1SelectAllCustomer() {
		List<Customer> listStd = service.selectAllCustomer();
		Assert.assertNotNull(listStd);

		for (Customer cs : listStd) {
			System.out.println(cs);
		}
	}
*/
	/*@Test
	public void test2SelectAllEmp() {
		List<Employee> listStd = service.selectAllEmployee();
		Assert.assertNotNull(listStd);
		for (Employee cs : listStd) {
			System.out.println(cs);
		}
	}*/

	@Test
	public void test3SelectAllCustomerEmpName() {
		List<Customer> listStd = service.SelectAllCustomerEmpName();
		Assert.assertNotNull(listStd);

		for (Customer cs : listStd) {
			System.out.println(cs);
		}
	}

	@Test
	public void test5inSertCustomer() {
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 2, 15);
		Customer ctm = new Customer();
		ctm.setCusNo(13);
		ctm.setCusName("dddd");
		ctm.setBirth(newDate.getTime());
		ctm.setJoinDate(newDate.getTime());
		ctm.setPhoneNumber(new PhoneNumber("010-0000-0000"));
		ctm.setAge(15);
		ctm.setAddr("대구관ㅇㅁㅇ");
		ctm.setEmp(new Employee(4));
		ctm.setcTf(true);
		int res = service.inSertCustomer(ctm);
		Assert.assertEquals(1, res);
	}

}
