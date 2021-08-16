package kr.or.kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.kosta.dto.empDTO;

public class empDAO {
	private static empDAO instance=new empDAO();
	public static empDAO getInstance()
	{
		return instance;
	}
	private empDAO() {}
	
	//DB연결
	private Connection getConnection()
	{
		Connection conn=null;
		try {
			Context init=new InitialContext();
			DataSource ds=(DataSource)init.lookup("java:comp/env/jdbc/kosta");
			conn=ds.getConnection();
		}catch(NamingException | SQLException e) {
			System.out.println(e);
		}
		return conn;
	}
	//list
	public List<empDTO> getList()
	{
		StringBuilder sql=new StringBuilder();
		sql.append("  select                 ");
		sql.append("           employee_id   ");
		sql.append("          , first_name   ");
		sql.append("          , hire_date    ");
		sql.append("          , salary       ");
		sql.append("          , department_id ");
		sql.append("  from emp2               ");
		
		ResultSet rs=null;
		List<empDTO> list=new ArrayList<empDTO>();
		try(Connection conn=getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql.toString());	
			){
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				empDTO dto=new empDTO();
				dto.setEmployee_id(rs.getInt("employee_id"));
				dto.setFirst_name(rs.getString("first_name"));
				dto.setHire_date(rs.getString("hire_date"));
				dto.setSalary(rs.getFloat("salary"));
				dto.setDepartment_id(rs.getInt("department_id"));
				
				list.add(dto);
			}
		}catch(SQLException e)
		{
			System.out.println(e);
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
		}
		return list;
	}
}
