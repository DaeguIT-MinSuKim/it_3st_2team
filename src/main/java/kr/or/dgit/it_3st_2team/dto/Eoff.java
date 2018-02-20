package kr.or.dgit.it_3st_2team.dto;

import java.util.Date;

public class Eoff {
	private Employee empNo;
	private Date eoffDay;
	private Eoff() {
		// TODO Auto-generated constructor stub
	}
	private Eoff(Employee empNo, Date eoffDay) {
		super();
		this.empNo = empNo;
		this.eoffDay = eoffDay;
	}
	public Employee getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Employee empNo) {
		this.empNo = empNo;
	}
	public Date getEoffDay() {
		return eoffDay;
	}
	public void setEoffDay(Date eoffDay) {
		this.eoffDay = eoffDay;
	}
	@Override
	public String toString() {
		return String.format("Eoff [empNo=%s, eoffDay=%s]", empNo, eoffDay);
	}
	
	
}
