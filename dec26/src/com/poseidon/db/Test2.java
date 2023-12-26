package com.poseidon.db;

import java.util.List;

public class Test2 {
	public static void main(String[] args) {
		
		EmployeesDAO dao = new EmployeesDAO();
		List<EmployeesDTO> result = dao.selectEmployees() ;

		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i).getEMP_no()+" : ");
	         System.out.print(result.get(i).getBirth_date()+" : ");
	         System.out.print(result.get(i).getFirst_name()+" : ");
	         System.out.print(result.get(i).getLast_name()+" : ");
	         System.out.print(result.get(i).getGender()+" : ");
	         System.out.println(result.get(i).getHire_date());
		}
		
	}

}
