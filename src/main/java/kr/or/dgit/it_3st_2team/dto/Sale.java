package kr.or.dgit.it_3st_2team.dto;

import java.util.Date;

public class Sale { //Foreign key에 대한 변수타입 수정 kim 2018-02-22
	private int saleNo;
	private String description;
	private Date sDate;
	private Date sTime;
	private Customer cus; 
	private Employee emp;
	private Event evn;
	private int sPrice;
	public Sale() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sale(int saleNo, String description, Date sDate, Date sTime, Customer cus, Employee emp, Event evn,
			int sPrice) {
		super();
		this.saleNo = saleNo;
		this.description = description;
		this.sDate = sDate;
		this.sTime = sTime;
		this.cus = cus;
		this.emp = emp;
		this.evn = evn;
		this.sPrice = sPrice;
	}
	public int getSaleNo() {
		return saleNo;
	}
	public void setSaleNo(int saleNo) {
		this.saleNo = saleNo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getsDate() {
		return sDate;
	}
	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}
	public Date getsTime() {
		return sTime;
	}
	public void setsTime(Date sTime) {
		this.sTime = sTime;
	}
	public Customer getCus() {
		return cus;
	}
	public void setCus(Customer cus) {
		this.cus = cus;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public Event getEvn() {
		return evn;
	}
	public void setEvn(Event evn) {
		this.evn = evn;
	}
	public int getsPrice() {
		return sPrice;
	}
	public void setsPrice(int sPrice) {
		this.sPrice = sPrice;
	}
	@Override
	public String toString() {
		return String.format("Sale [saleNo=%s, description=%s, sDate=%s, sTime=%s, cus=%s, emp=%s, evn=%s, sPrice=%s]",
				saleNo, description, sDate, sTime, cus, emp, evn, sPrice);
	}
	
	
}