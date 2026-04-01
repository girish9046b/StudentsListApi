package com.student.app.service.impl;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.student.app.dao.intf.StudentDaoIntf;
import com.student.app.error.ErrorMessageHandler;
import com.student.app.model.Student;
import com.student.app.response.Response;
import com.student.app.service.intf.StudentServiceIntf;

@Service("studentServicemysql")
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class StudentServiceMysql implements StudentServiceIntf {

	private static final Logger logger = LoggerFactory.getLogger(StudentServiceMysql.class);

	private Response response; // Field is final, ensuring immutability
	private Student student; // Field is final, ensuring immutability
	private ErrorMessageHandler errorMessageHandler; // Field is final, ensuring immutability
	private StudentDaoIntf studentdao; // check interface and dao this has two references sqlquery and procedures

	// Constructor for injection (Spring automatically injects ReportDAO here)
	public StudentServiceMysql(Response response, Student student, ErrorMessageHandler errorMessageHandler,
			@Qualifier("studentmysqldao") StudentDaoIntf studentdao) {
		this.response = response;
		this.errorMessageHandler = errorMessageHandler;
		this.student = student;
		this.studentdao = studentdao;
	}

	public Response getAllStudents() throws Exception {
		logger.info("getAllStudentsmysqlgetAllStudentsmysqlgetAllStudentsmysql-----222");
		response.setStudentlist(studentdao.getAllStudents());
		if (response.getStudentlist().isEmpty()) {
			errorMessageHandler.addErrortoList(404);
			//throw new ResourceNotFoundException("Item ID " + id + " not found");
		}
return response;
	}

}
