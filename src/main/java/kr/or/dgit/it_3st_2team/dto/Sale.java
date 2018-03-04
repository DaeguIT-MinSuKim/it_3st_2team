package kr.or.dgit.it_3st_2team.dto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sale { //Foreign key에 대한 변수타입 수정 kim 2018-02-22
	private int saleNo;
	private String description;
	private Date sDate;
	private Date sTime;
	private Customer cus; 
	private Employee emp;
	private Event evn;
	private int sPrice;
	//khj 20180228 일대다
	private List<Hair> hairs;
	
	
	/*hair변수  get,set 추가 yyj 02-07*/
	private Hair hair;
	public Sale() {
		super();
	}
	
	public Sale(int saleNo, String description, Date sDate, Date sTime, Customer cus, Employee emp, Event evn, int sPrice) {
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

	public Hair getHair() {
		return hair;
	}
	public void setHair(Hair hair) {
		this.hair = hair;
	}
	//khj
	public Sale(int saleNo, Date sDate, Date sTime, Customer cus, Employee emp, Event evn, int sPrice) {
		super();
		this.saleNo = saleNo;
		this.sDate = sDate;
		this.sTime = sTime;
		this.cus = cus;
		this.emp = emp;
		this.evn = evn;
		this.sPrice = sPrice;
	}
	
	//khj 20180228 헤어주문 삭제기능을 위함
	public Sale(int saleNo) {
		super();
		this.saleNo = saleNo;
	}
	
	// khj 헤어주문 수정기능을 위함
	public Sale(int saleNo, Customer cus, Employee emp, Event evn, int sPrice) {
		super();
		this.saleNo = saleNo;
		this.cus = cus;
		this.emp = emp;
		this.evn = evn;
		this.sPrice = sPrice;
	}

	//khj 헤어주문 고객검색기능을 위함
	public Sale(Customer cus) {
		super();
		this.cus = cus;
	}

	//khj 헤어주문 기간검색기능을 위함
	public Sale(Date sDate) {
		super();
		this.sDate = sDate;
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

	public String toString() {
		return String.format("Sale [saleNo=%s, description=%s, sDate=%s, sTime=%s, cus=%s, emp=%s, evn=%s, sPrice=%s]",
				saleNo, description, sDate, sTime, cus, emp, evn, sPrice);
	}
	
	//khj
	public Object[] toArray() {
		return new Object[] {saleNo, sDate, sTime, cus, emp, evn, sPrice};
	}
	//khj
	public String getHairElement() {
		List<String> hairList = new ArrayList<>();
		for(Hair h:hairs) {
			hairList.add(h.getHairName());
		}
		return hairList.toString();
	}
	
	public Object[] toArraySelectAllSale() {
		return new Object[] {saleNo,dateToString(sDate),timeToString(sTime),cus.getCusName(),emp.getEmpName(), evn.getEvnName(), sPrice, getHairElement()};		
	}
	/*	yyj*/
	public Object[] toArrayMonth() {
		/*return new Object[] {saleNo,dateToString(sDate),timeToString(sTime),cus.getCusName(),hair.getHairName(),evn.getEvnName(),sPrice};*/
		return new Object[] {saleNo,dateToString(sDate),timeToString(sTime),cus.getCusName(),getHairElement(),evn.getEvnName(),sPrice};
	}
	public String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	public String timeToString(Date stime) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		return sdf.format(stime);
	}
}
