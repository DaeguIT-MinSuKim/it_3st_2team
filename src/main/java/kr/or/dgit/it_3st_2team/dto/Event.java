package kr.or.dgit.it_3st_2team.dto;

public class Event {
	private int evnNo;
	private String evnName;
	private float discount;
	
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Event(int evnNo, String evnName, float discount) {
		super();
		this.evnNo = evnNo;
		this.evnName = evnName;
		this.discount = discount;
	}
	public int getEvnNo() {
		return evnNo;
	}
	public void setEvnNo(int evnNo) {
		this.evnNo = evnNo;
	}
	public String getEvnName() {
		return evnName;
	}
	public void setEvnName(String evnName) {
		this.evnName = evnName;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "Event [evnNo=" + evnNo + ", evnName=" + evnName + ", discount=" + discount + "]";
	}
	
	
}
