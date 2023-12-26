package com.poseidon.db;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		
		EmployeesDAO dao = new EmployeesDAO();
		List<EmployeesDTO> result = dao.selectDepartments() ;

		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i).getDept_no()+" : ");
			System.out.println(result.get(i).getDept_name());
		}
		
	}

}
