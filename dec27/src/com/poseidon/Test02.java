package com.poseidon;

import java.util.List;

import com.poseidon.dao.EmployeesDAO;
import com.poseidon.dto.EmployeesDTO;

public class Test02 {

	public static void main(String[] args) {
		
		EmployeesDAO dao = new EmployeesDAO();
		List<EmployeesDTO> list = dao.selectEmployees();
		
		System.out.println(list.size());
		
		for (EmployeesDTO employeesDTO : list) {
			System.out.println(list);
		}
		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.print(list.get(i).getEmp_no()+" : ");
//			System.out.print(list.get(i).getBirth_date()+" : ");
//			System.out.print(list.get(i).getFirst_name()+" : ");
//			System.out.print(list.get(i).getLast_name()+" : ");
//			System.out.print(list.get(i).getGender()+" : ");
//			System.out.println(list.get(i).getHire_date());
//		}
		
	}
}
