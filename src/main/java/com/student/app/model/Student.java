package com.student.app.model;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class Student {
	
	private long id;
	private String name;
	private String acceptForm;
	

}
