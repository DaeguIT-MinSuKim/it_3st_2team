package kr.or.dgit.it_3st_2team.dto;

import java.util.Date;

public class Employee {
	private int empNo;
	private String empName;
	private Date joinDate;
	private String addr;
	private String id;
	private String epassword;
	private Title title;
	private int eOff;
	private Boolean eTf;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Employee(int empNo, String empName, Date joinDate, String addr, String id, String epassword, Title title,
			int eOff, Boolean eTf) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.joinDate = joinDate;
		this.addr = addr;
		this.id = id;
		this.epassword = epassword;
		this.title = title;
		this.eOff = eOff;
		this.eTf = eTf;
	}

	public Employee(String id, String password) {
		super();
		this.id = id;
		this.epassword = password;
	}

	private Employee(String empName, Title titleNo) {
		super();
		this.empName = empName;
		this.title = titleNo;
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

	public String getEpassword() {
		return epassword;
	}

	public void setEpassword(String epassword) {
		this.epassword = epassword;
	}

	public String getPassword() {
		return epassword;
	}

	public void setPassword(String password) {
		this.epassword = password;
	}

	public Title getTitleNo() {
		return title;
	}

	public void setTitleNo(Title title) {
		this.title = title;
	}

	public int geteOff() {
		return eOff;
	}

	public void seteOff(int eOff) {
		this.eOff = eOff;
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

				"Employee [empNo=%s, empName=%s, joinDate=%s, addr=%s, id=%s, epassword=%s, titleNo=%s, eOff=%s, eTf=%s]",
				empNo, empName, joinDate, addr, id, epassword, title, eOff, eTf);
	}
}