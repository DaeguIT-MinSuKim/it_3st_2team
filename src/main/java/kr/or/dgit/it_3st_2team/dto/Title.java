package kr.or.dgit.it_3st_2team.dto;

public class Title {
	private int titleNo;
	private String titleName;

	public Title() {
		super();
	}
	
	public Title(String titleName) {
		this.titleName = titleName;
	}

	public Title(int titleNo) {
		this.titleNo = titleNo;
	}

	public Title(int titleNo, String titleName) {
		this.titleNo = titleNo;
		this.titleName = titleName;
	}

	public int getTitleNo() {
		return titleNo;
	}

	public void setTitleNo(int titleNo) {
		this.titleNo = titleNo;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public Object[] toArray() {
		return new Object[] { titleNo, titleName };
	}

	@Override
	public String toString() {
		return String.format("%s", titleName);
	}
	

}
