package com.test.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.database.DBconnection;
import com.test.models.Student;

public class Studentservicesimpl implements Studentservices

{
	Connection con = null;
	public Studentservicesimpl()
	{
		
		con= DBconnection.getdbconnnection();
		
		
	}
	
	
	
	
	@Override
	public boolean addstudent(Student s)
	{
		
		

		String sql ="insert into school(Name,Address,Phone,Sex,Faculty,DOB,Photo) values(?,?,?,?,?,?,?)";
		
		
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1,s.getName());
			pstm.setString(2,s.getAddress());
			pstm.setString(3,s.getPhone());
			pstm.setString(4,s.getSex());
			pstm.setString(5,s.getFaculty());
			pstm.setString(6,s.getDOB());
			pstm.setBytes(7, s.getPhoto());
			pstm.execute();
			
			
			return true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return false;
	}

	@Override
	public boolean deletestudent(int id) {
	

		String sql = "delete from school where id ='"+id+"' ";
		try
		{
Statement stm	=con.createStatement();
		stm.execute(sql);
		
		return true;
	
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;

		
		
		
	
	}

	@Override
	public Student getbyid(int id) {
		
		Student s = new Student();
		String sql ="select * from school where id='"+id+"'";
		

		try {
			Statement 	stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next())
				
			{
			
				s.setName(rs.getString("Name"));
				s.setAddress(rs.getString("Address"));
				s.setPhone(rs.getString("phone"));
				s.setSex(rs.getString("sex"));
				s.setFaculty(rs.getString("Faculty"));
				s.setDOB(rs.getString("DOB"));
				s.setPhoto(rs.getBytes("Photo"));
				
				
				
			}
			return s;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		return s;
	}
	
		
		
		
		
	
	@Override
	public boolean updateStudent(Student s) {


		String sql = "update school set Name=?,Address=?,Phone=?,Sex=?,Faculty=?,DOB=?,Photo=? where id =?";

		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, s.getName());
			pstm.setString(2, s.getAddress());
			pstm.setString(3, s.getPhone());
			pstm.setString(4, s.getSex());
			pstm.setString(5, s.getFaculty());
			pstm.setString(6, s.getDOB());
	        pstm.setBytes(7, s.getPhoto());
			
			pstm.setInt(8,s.getID());
			pstm.execute();
			return true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return false;
	}
		
		
		
	

	@Override
	public List<Student> getstudents() {
	
		List<Student> slist = new ArrayList<Student>();
		String sql ="select * from school";
		
	
		try {
			Statement	stm = con.createStatement();
			ResultSet rs =stm.executeQuery(sql);
			
			while(rs.next())
			{
				Student s = new Student();
				
				s.setID(rs.getInt("ID"));
				s.setName(rs.getString("Name"));
				s.setAddress(rs.getString("Address"));
				s.setPhone(rs.getString("phone"));
				s.setSex(rs.getString("Sex"));
				s.setFaculty(rs.getString("Faculty"));
				s.setDOB(rs.getString("DOB"));
				s.setPhoto(rs.getBytes("Photo"));
				
			
				slist.add(s);
			}
			
			return slist;
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		return slist;
	}
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	

}
