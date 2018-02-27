package kr.or.dgit.it_3st_2team.dto;

public class Enroll {
	private int enrollNo;
	private int saleNo;
	private int hairNo;
	private Enroll() {
		// TODO Auto-generated constructor stub
	}
	public Enroll(int enrollNo, int saleNo, int hairNo) {
		super();
		this.enrollNo = enrollNo;
		this.saleNo = saleNo;
		this.hairNo = hairNo;
	}
	
	public Enroll(int saleNo, int hairNo) { //khj auto-increment
		super();
		this.saleNo = saleNo;
		this.hairNo = hairNo;
	}
	public int getEnrollNo() {
		return enrollNo;
	}
	public void setEnrollNo(int enrollNo) {
		this.enrollNo = enrollNo;
	}
	public int getSaleNo() {
		return saleNo;
	}
	public void setSaleNo(int saleNo) {
		this.saleNo = saleNo;
	}
	public int getHairNo() {
		return hairNo;
	}
	public void setHairNo(int hairNo) {
		this.hairNo = hairNo;
	}
	@Override
	public String toString() {
		return String.format("Enroll [enrollNo=%s, saleNo=%s, hairNo=%s]", enrollNo, saleNo, hairNo);
	}
	
	
	
	
}
