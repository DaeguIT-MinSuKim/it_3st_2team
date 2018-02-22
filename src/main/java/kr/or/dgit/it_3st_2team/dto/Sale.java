package kr.or.dgit.it_3st_2team.dto;

import java.util.Date;

public class Sale { //Foreign key에 대한 변수타입 수정 kim 2018-02-22
	private int saleNo;
	private String description;
	private Date sDate;
	private Date sTime;
	private Customer cusNo; 
	private Employee empNo;
	private Event evnNo;
	private int sPrice;
	public Sale() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sale(int saleNo, String description, Date sDate, Date sTime, Customer cusNo, Employee empNo, Event evnNo, int sPrice) {
		super();
		this.saleNo = saleNo;
		this.description = description;
		this.sDate = sDate;
		this.sTime = sTime;
		this.cusNo = cusNo;
		this.empNo = empNo;
		this.evnNo = evnNo;
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
	public Customer getCusNo() {
		return cusNo;
	}
	public void setCusNo(Customer cusNo) {
		this.cusNo = cusNo;
	}
	public Employee getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Employee empNo) {
		this.empNo = empNo;
	}
	public Event getEvnNo() {
		return evnNo;
	}
	public void setEvnNo(Event evnNo) {
		this.evnNo = evnNo;
	}
	public int getsPrice() {
		return sPrice;
	}
	public void setsPrice(int sPrice) {
		this.sPrice = sPrice;
	}
	@Override
	public String toString() {
		return String.format(
				"Sale [saleNo=%s, description=%s, sDate=%s, sTime=%s, cusNo=%s, empNo=%s, evnNo=%s, sPrice=%s]", saleNo,
				description, sDate, sTime, cusNo, empNo, evnNo, sPrice);
	}
	
}