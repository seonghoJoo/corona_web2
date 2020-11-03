package org.corona.vo;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

public class Trip {

	private int no,num;
	private String place,city,gu;
	private Date startDate, endDate;
	private double latitude, longtitude;
	private char mask;
	private Calendar start,end;
	private int nowYear;
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
	private Timestamp regdate;
	public Trip() {
		start = Calendar.getInstance();
		end = Calendar.getInstance();
		nowYear = start.get(Calendar.YEAR);
		
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
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		start.setTime(startDate);
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		end.setTime(endDate);
		this.endDate = endDate;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}
	public char getMask() {
		return mask;
	}
	public void setMask(char mask) {
		this.mask = mask;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public int getStartYear() {
		return start.get(Calendar.YEAR);
	}
	
	public int getStartMonth() {
		return start.get(Calendar.MONTH)+1;
	}
	
	public int getStartDay() {
		return start.get(Calendar.DATE);
	}
	
	public int getEndYear() {
		return end.get(Calendar.YEAR);
	}
	
	public int getEndMonth() {
		return end.get(Calendar.MONTH)+1;
	}
	
	public int getEndDay() {
		return end.get(Calendar.DATE);
	}
	
}
