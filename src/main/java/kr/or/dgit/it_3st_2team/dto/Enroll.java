package kr.or.dgit.it_3st_2team.dto;

public class Enroll {
	private Sale saleNo;
	private Hair hairNo;
	private Enroll() {
		// TODO Auto-generated constructor stub
	}
	private Enroll(Sale saleNo, Hair hairNo) {
		super();
		this.saleNo = saleNo;
		this.hairNo = hairNo;
	}
	public Sale getSaleNo() {
		return saleNo;
	}
	public void setSaleNo(Sale saleNo) {
		this.saleNo = saleNo;
	}
	public Hair getHairNo() {
		return hairNo;
	}
	public void setHairNo(Hair hairNo) {
		this.hairNo = hairNo;
	}
	@Override
	public String toString() {
		return String.format("Enroll [saleNo=%s, hairNo=%s]", saleNo, hairNo);
	}

	
	
}
