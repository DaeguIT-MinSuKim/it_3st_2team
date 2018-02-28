package kr.or.dgit.it_3st_2team.dto;

public class Hair {
	private int hairNo;
	private String hairName;
	private int price;
	
	private Hair() {
	}
	public Hair(int hairNo, String hairName, int price) {
		this.hairNo = hairNo;
		this.hairName = hairName;
		this.price = price;
	}
	public int getHairNo() {
		return hairNo;
	}
	public void setHairNo(int hairNo) {
		this.hairNo = hairNo;
	}
	public String getHairName() {
		return hairName;
	}
	public void setHairName(String hairName) {
		this.hairName = hairName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return String.format("Hair [hairNo=%s, hairName=%s, price=%s]", hairNo, hairName, price);
	}
	public Object[] toArray() {
		return new Object[] {hairNo, hairName,price};
	}
	
	
}
