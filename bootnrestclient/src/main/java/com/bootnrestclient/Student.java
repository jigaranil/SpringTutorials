package com.bootnrestclient;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Student {
	private long id;
	private String name;
	private String subject;

	public Student() {
    }
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Student{" + "id=" + id + ", name='" + name + '\'' + ", subject='" + subject + '\'' + '}';
	}

	public Student(String name, String subject) {
        this.id = (new Date()).getTime();
        this.name = name;
        this.subject = subject;
    }
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
