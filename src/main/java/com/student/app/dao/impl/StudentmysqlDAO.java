package com.student.app.dao.impl;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.WebApplicationContext;

import com.student.app.dao.intf.StudentDaoIntf;
import com.student.app.model.Student;

@Repository(value = "studentmysqldao")
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class StudentmysqlDAO implements StudentDaoIntf {

	private static final Logger logger = LoggerFactory.getLogger(StudentmysqlDAO.class);

	private NamedParameterJdbcTemplate jdbcTemplate;

	private Student student; // Field is final, ensuring immutability

	// Constructor for injection (Spring automatically injects ReportDAO here)
	public StudentmysqlDAO(@Qualifier("mysqlTemplate4") NamedParameterJdbcTemplate jdbcTemplate, Student student) {
		this.jdbcTemplate = jdbcTemplate;
		this.student = student;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Student> getAllStudents() throws Exception {
		String sql = "SELECT * FROM student";
		return (ArrayList<Student>) jdbcTemplate.query(sql, new StudentRowMapper());
	}

}
