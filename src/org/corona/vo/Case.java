package org.corona.vo;

public class Case {
	private int no, num;
	private String city, gu;
	public Case() {
		
	}
	public Case(int num, String city, String gu) {
		this(0,num,city,gu);
	}
	
	public Case(int no, int num, String city, String gu) {
		this.no = no;
		this.num = num;
		this.city = city;
		this.gu = gu;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGu() {
		return gu;
	}
	public void setGu(String gu) {
		this.gu = gu;
	}
	
	
}
