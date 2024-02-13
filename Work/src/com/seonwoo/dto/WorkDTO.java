package com.seonwoo.dto;

import java.util.Date;

public class WorkDTO {
	private int wNo,wSet,wNumber,wSec;
	private String wName, wType;
	private Date wDate;
	public int getwNo() {
		return wNo;
	}
	public void setwNo(int wNo) {
		this.wNo = wNo;
	}
	public int getwSet() {
		return wSet;
	}
	public void setwSet(int wSet) {
		this.wSet = wSet;
	}
	public int getwNumber() {
		return wNumber;
	}
	public void setwNumber(int wNumber) {
		this.wNumber = wNumber;
	}
	public int getwSec() {
		return wSec;
	}
	public void setwSec(int wSec) {
		this.wSec = wSec;
	}
	public String getwName() {
		return wName;
	}
	public void setwName(String wName) {
		this.wName = wName;
	}
	public Date getwDate() {
		return wDate;
	}
	public void setwDate(Date wDate) {
		this.wDate = wDate;
	}
	public String getwType() {
		return wType;
	}
	public void setwType(String wType) {
		this.wType = wType;
	}

}
