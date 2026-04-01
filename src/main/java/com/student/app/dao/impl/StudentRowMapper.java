package com.student.app.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.student.app.model.Student;


public class StudentRowMapper implements RowMapper {  
 public Student mapRow(ResultSet rs, int rowNum) throws SQLException {  
	 Student student = new Student();  
	 student.setName(rs.getString("name"));
	 student.setId(rs.getLong("id"));
	 student.setAcceptForm(rs.getString("acceptForm"));
  return student;  
 }  
}  