package com.poseidon;

import java.util.List;

import com.poseidon.dao.EmployeesDAO;
import com.poseidon.dto.EmployeesDTO;

public class Recommand {

	public static void main(String[] args) {
		
		EmployeesDAO dao = new EmployeesDAO();
		List<EmployeesDTO> list = dao.recommandEmp("Aamer");
		
		System.out.println(list.size());
		int num = 3;
		
//		int ran = (int)(Math.random()*num+1);
//		System.out.println(ran);
		
		
		for (int i = 0; i < num; i++) {
			int ran = (int)(Math.random()*num+1);
			System.out.print(list.get(ran).getEmp_no()+" : ");
			System.out.print(list.get(ran).getBirth_date()+" : ");
			System.out.print(list.get(ran).getFirst_name()+" : ");
			System.out.print(list.get(ran).getLast_name()+" : ");
			System.out.print(list.get(ran).getGender()+" : ");
			System.out.println(list.get(ran).getHire_date());
		}

		
	}
}
