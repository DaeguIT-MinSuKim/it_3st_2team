package kr.or.dgit.it_3st_2team.dto;

public class Event {
	private Integer evnNo;
	private String evnName;
	private Float discount;

	public Event() {

	}

	public Event(Integer evnNo, String evnName, Float discount) {
		this.evnNo = evnNo;
		this.evnName = evnName;
		this.discount = discount;
	}

	public Integer getEvnNo() {
		return evnNo;
	}

	public void setEvnNo(Integer evnNo) {
		this.evnNo = evnNo;
	}

	public String getEvnName() {
		return evnName;
	}

	public void setEvnName(String evnName) {
		this.evnName = evnName;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return String.format("Event [evnNo=%s, evnName=%s, discount=%s]", evnNo, evnName, discount);
	}

}
