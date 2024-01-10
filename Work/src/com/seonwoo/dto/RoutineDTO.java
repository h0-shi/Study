package com.seonwoo.dto;

import java.util.Date;

public class RoutineDTO {
	private int id;
	private String name, wNames;
	private Date wDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getwNames() {
		return wNames;
	}
	public void setwNames(String wNames) {
		this.wNames = wNames;
	}
	public Date getwDate() {
		return wDate;
	}
	public void setwDate(Date wDate) {
		this.wDate = wDate;
	}

	
}
