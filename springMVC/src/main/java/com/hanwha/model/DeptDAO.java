package com.hanwha.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanwha.util.DBUtil_Oracle;


/*
 * DAO(Data Access Object): Business logic
 */
//<bean id="deptDAO" class="com.hanwha.model.DeptDAO">

//DeptDAO 클래스를 객체로 만들어줌
@Repository
public class DeptDAO {
	
	@Autowired
	DataSource ds;
	
	public List<DeptDTO> selectAll() {

		List<DeptDTO> deptlist = new ArrayList<>(); // �룞�쟻 諛곗뿴

		Connection conn = null;
		
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from departments";

		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int deptid = rs.getInt("department_id");
				String dname = rs.getString("department_name");
				// System.out.println(deptid + " " + dname);
				DeptDTO dept = new DeptDTO(deptid, dname);
				deptlist.add(dept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil_Oracle.dBClose(rs, st, conn);
		}

		return deptlist;

	}

	public DeptDTO selectById(int deptid) {  //遺��꽌 ID �긽�꽭蹂닿린
		DeptDTO dept = null; // �룞�쟻 諛곗뿴
		Connection conn = null;

	
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from departments where department_id = " + deptid;

		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String dname = rs.getString("department_name");
				// System.out.println(deptid + " " + dname);
				dept = new DeptDTO(deptid, dname);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil_Oracle.dBClose(rs, st, conn);
		}

		return dept;
	}

	public int insertDept(DeptDTO dept) {
		Connection conn = null;

		PreparedStatement st = null;
		int result = 0;
		String sql = "insert into departments(department_id, department_name ) values(?,?)";
		
		try {
			conn = ds.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, dept.getDepartment_id());
			st.setString(2, dept.getDepartment_name());
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateDept(DeptDTO dept) {
		Connection conn = null;
		PreparedStatement st = null;
		int result = 0;
		String sql = "update departments set department_name=? where department_id= ?";
		
		try {
			conn = ds.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(2, dept.getDepartment_id());
			st.setString(1, dept.getDepartment_name());
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	
	public int deleteDept(int dept) {
		Connection conn = null;
		PreparedStatement st = null;
		int result = 0;
		String sql = "delete from departments where department_id= ?";
		
		try {
			conn = ds.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, dept);
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	

	

}
