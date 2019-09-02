package com.hanwha.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAO_Mybatis {
	
	@Autowired
	SqlSession session;
	String namespace = "com.hanwha.emp.";
	
	public List<Integer> selectAllManager() {
		return session.selectList(namespace+ "selectallmanager");
	}
	
	public Object selectAllJob() {
		return session.selectList(namespace + "selectalljob");
	}
	
	public List<EmpVO> selectAll() {
		return session.selectList(namespace + "selectall");
	}
	


	public EmpVO selectById(int empid) {
		return session.selectOne(namespace + "selectById", empid);
	}
	
	public int insertEmp(EmpVO emp) {
		return session.insert(namespace + "insert", emp);
	}
	
	
	public int updateEmp(EmpVO emp) {
		return session.update(namespace + "update", emp);
	}

	public int deleteEmp(int emp) {
		return session.delete(namespace + "delete", emp);
	}





}
