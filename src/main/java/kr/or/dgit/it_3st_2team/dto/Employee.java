package kr.or.dgit.it_3st_2team.dto;

import java.text.SimpleDateFormat;
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
	
	public Employee(Boolean eTf) {
		super();
		this.eTf = eTf;
	}

	private Employee(String empName, Title titleNo) {
		super();
		this.empName = empName;
		this.title = titleNo;
	}

	public Employee(String empName) {
		super();
		this.empName = empName;
	}

	public Employee(int empNo) {
		super();
		this.empNo = empNo;
	}



	public Employee(String string, String string2, String string3, String string4) {
		// TODO Auto-generated constructor stub
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

	public String getEOffToString() {
		if(eOff==0) {
			return String.format("월","%s", eOff);
		}else if(eOff==1) {
			return String.format("화","%s", eOff);
		}else if(eOff==2) {
			return String.format("수","%s", eOff);
		}else if(eOff==3) {
			return String.format("목","%s", eOff);
		}else if(eOff==4) {
			return String.format("금","%s", eOff);
		}else if(eOff==5) {
			return String.format("토","%s", eOff);
		}else {
			return String.format("일","%s", eOff);
		}
	}
	
	public Object[] toArrayNoandName() {
		return new Object[] {empNo, empName};
	}

	public Object[] toArray() {
		String Sdf = new SimpleDateFormat("yyyy-mm-dd").format(joinDate);
		return new Object[] { empNo, empName, Sdf, addr,id, epassword, title.getTitleName(),getEOffToString(),eTf };
	}

	
	

}