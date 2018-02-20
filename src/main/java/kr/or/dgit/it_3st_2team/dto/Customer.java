package kr.or.dgit.it_3st_2team.dto;

import java.util.Date;

public class Customer {
	private int cusNo;
	private String cusName;
	private Date birth;
	private int age;
	private Date joinDate;
	private PhoneNumber phone;
	private String addr;
	private Employee empNo;
	private Boolean cTf;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Customer(int cusNo, String cusName, Date birth, int age, Date joinDate, PhoneNumber phone, String addr,
			Employee empNo, Boolean cTf) {
		super();
		this.cusNo = cusNo;
		this.cusName = cusName;
		this.birth = birth;
		this.age = age;
		this.joinDate = joinDate;
		this.phone = phone;
		this.addr = addr;
		this.empNo = empNo;
		this.cTf = cTf;
	}
	public int getCusNo() {
		return cusNo;
	}
	public void setCusNo(int cusNo) {
		this.cusNo = cusNo;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public PhoneNumber getPhone() {
		return phone;
	}
	public void setPhone(PhoneNumber phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Employee getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Employee empNo) {
		this.empNo = empNo;
	}
	public Boolean getcTf() {
		return cTf;
	}
	public void setcTf(Boolean cTf) {
		this.cTf = cTf;
	}
	@Override
	public String toString() {
		return String.format(
				"Customer [cusNo=%s, cusName=%s, birth=%s, age=%s, joinDate=%s, phone=%s, addr=%s, empNo=%s, cTf=%s]",
				cusNo, cusName, birth, age, joinDate, phone, addr, empNo, cTf);
	}
	
	
	
}
