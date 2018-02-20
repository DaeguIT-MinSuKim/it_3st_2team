package kr.or.dgit.it_3st_2team.dto;

import java.sql.Time;
import java.util.Date;

public class Sale {
	private Integer saleNo;
	private String description;
	private Date sdate;
	private Time stime;
	private Integer cusNo;
	private Integer empNo;
	private Integer evnNo;
	private Integer sprice;

	public Sale() {

	}

	public Sale(Integer saleNo, String description, Date sdate, Time stime, Integer cusNo, Integer empNo, Integer evnNo,
			Integer sprice) {
		this.saleNo = saleNo;
		this.description = description;
		this.sdate = sdate;
		this.stime = stime;
		this.cusNo = cusNo;
		this.empNo = empNo;
		this.evnNo = evnNo;
		this.sprice = sprice;
	}

	public Integer getSaleNo() {
		return saleNo;
	}

	public void setSaleNo(Integer saleNo) {
		this.saleNo = saleNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getSdate() {
		return sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	public Time getStime() {
		return stime;
	}

	public void setStime(Time stime) {
		this.stime = stime;
	}

	public Integer getCusNo() {
		return cusNo;
	}

	public void setCusNo(Integer cusNo) {
		this.cusNo = cusNo;
	}

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public Integer getEvnNo() {
		return evnNo;
	}

	public void setEvnNo(Integer evnNo) {
		this.evnNo = evnNo;
	}

	public Integer getSprice() {
		return sprice;
	}

	public void setSprice(Integer sprice) {
		this.sprice = sprice;
	}

	@Override
	public String toString() {
		return String.format(
				"Sale [saleNo=%s, description=%s, sdate=%s, stime=%s, cusNo=%s, empNo=%s, evnNo=%s, sprice=%s]", saleNo,
				description, sdate, stime, cusNo, empNo, evnNo, sprice);
	}

}
