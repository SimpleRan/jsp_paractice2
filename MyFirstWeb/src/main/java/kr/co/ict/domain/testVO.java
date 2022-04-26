package kr.co.ict.domain;

import java.sql.Date;

public class testVO {

	private int num;
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
		return "testVO [num=" + num + ", udate=" + udate + ", utime=" + utime + ", person=" + person + ", review="
				+ review + "]";
	}
	
	
}
