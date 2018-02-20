package kr.or.dgit.it_3st_2team.dto;

import java.util.Date;

public class Employee {
	private int empNo;
	private String empName;
	private Date joinDate;
	private String addr;
	private String id;
	private String password;
	private Title titleNo;
	private Boolean eTf;
	
	public Employee() {
	}
	public Employee(int empNo, String empName, Date joinDate, String addr, String id, String password, Title titleNo,
			Boolean eTf) {
		this.empNo = empNo;
		this.empName = empName;
		this.joinDate = joinDate;
		this.addr = addr;
		this.id = id;
		this.password = password;
		this.titleNo = titleNo;
		this.eTf = eTf;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Title getTitleNo() {
		return titleNo;
	}
	public void setTitleNo(Title titleNo) {
		this.titleNo = titleNo;
	}
	public Boolean geteTf() {
		return eTf;
	}
	public void seteTf(Boolean eTf) {
		this.eTf = eTf;
	}
	@Override
	public String toString() {
		return String.format(
				"Employee [empNo=%s, empName=%s, joinDate=%s, addr=%s, id=%s, password=%s, titleNo=%s, eTf=%s]", empNo,
				empName, joinDate, addr, id, password, titleNo, eTf);
	}
	
	
	
	
}
