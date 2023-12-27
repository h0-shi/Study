package com.poseidon;

import java.util.List;

import com.poseidon.dao.DepartmentsDAO;
import com.poseidon.dto.DepartmentsDTO;

public class Test01 {
	
	public static void main(String[] args) {
		
		DepartmentsDAO dao = new DepartmentsDAO();
		List<DepartmentsDTO> list =	dao.selectDepartments();
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).getDept_no()+" : ");
			System.out.println(list.get(i).getDept_name());
		}
		
	}

}
