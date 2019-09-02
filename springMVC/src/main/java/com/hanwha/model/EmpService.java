//POJO
package com.hanwha.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {

	
	@Autowired
	EmpDAO_Mybatis e_dao;
	//EmpDAO e_dao;
	
	public List<Integer> selectAllManager() {
		return e_dao.selectAllManager();
		
	}

	public Object selectAllJob() {
		return e_dao.selectAllJob();
	}
	
	public List<EmpVO> selectAll() {
		return e_dao.selectAll();
	}

	public EmpVO selectById(int empid) {
		return e_dao.selectById(empid);
	}
	public int insertEmp(EmpVO emp) {
		return e_dao.insertEmp(emp);
	}

	public int updateEmp(EmpVO emp) {
		return e_dao.updateEmp(emp);
	}

	public int deleteEmp(int emp) {
		return e_dao.deleteEmp(emp);
	}


}
