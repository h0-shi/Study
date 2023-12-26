package com.poseidon.db;
// 데이터 전송 객체
public class EmployeesDTO { // data transfer object
//	 데이터 전송 객체 (DTO)_ dto는 private으로 설정해야 함
	private String Dept_no, Dept_name;
	private int EMP_no;
	private String Birth_date, First_name, Last_name, Hire_date, Gender;
	
	
	public String getDept_no() {
		return Dept_no;
	}
	public void setDept_no(String dept_no) {
		Dept_no = dept_no;
	}
	public String getDept_name() {
		return Dept_name;
	}
	public void setDept_name(String dept_name) {
		Dept_name = dept_name;
	}
	public int getEMP_no() {
		return EMP_no;
	}
	public void setEMP_no(int eMP_no) {
		EMP_no = eMP_no;
	}
	public String getBirth_date() {
		return Birth_date;
	}
	public void setBirth_date(String birth_date) {
		Birth_date = birth_date;
	}
	public String getFirst_name() {
		return First_name;
	}
	public void setFirst_name(String first_name) {
		First_name = first_name;
	}
	public String getLast_name() {
		return Last_name;
	}
	public void setLast_name(String last_name) {
		Last_name = last_name;
	}
	public String getHire_date() {
		return Hire_date;
	}
	public void setHire_date(String hire_date) {
		Hire_date = hire_date;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	
	
//	getter / setter method	
	
}
