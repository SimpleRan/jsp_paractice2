package kr.co.ict.domain;

import java.sql.Date;

public class rVO {

	private int num;
	private String name;
	private int phone;
	private Date udate;
	private Date utime;
	private int person;
	private int review;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public Date getUdate() {
		return udate;
	}
	public void setUdate(Date udate) {
		this.udate = udate;
	}
	public Date getUtime() {
		return utime;
	}
	public void setUtime(Date utime) {
		this.utime = utime;
	}
	public int getPerson() {
		return person;
	}
	public void setPerson(int person) {
		this.person = person;
	}
	public int getReview() {
		return review;
	}
	public void setReview(int review) {
		this.review = review;
	}
	@Override
	public String toString() {
		return "rVO [num=" + num + ", name=" + name + ", phone=" + phone + ", udate=" + udate + ", utime=" + utime
				+ ", person=" + person + ", review=" + review + "]";
	}
}
	