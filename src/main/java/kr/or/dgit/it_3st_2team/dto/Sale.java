package kr.or.dgit.it_3st_2team.dto;

import java.util.Date;

public class Sale {
	private int saleNo;
	private String description;
	private Date sDate;
	private Date sTime;
	private int cusNo;
	private int empNo;
	private int evnNo;
	private int sPrice;
	public Sale() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sale(int saleNo, String description, Date sDate, Date sTime, int cusNo, int empNo, int evnNo, int sPrice) {
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
	public int getCusNo() {
		return cusNo;
	}
	public void setCusNo(int cusNo) {
		this.cusNo = cusNo;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public int getEvnNo() {
		return evnNo;
	}
	public void setEvnNo(int evnNo) {
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
