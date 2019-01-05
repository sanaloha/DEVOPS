package com.san.behavioral.student.iterator;

public class Student {

	private String name;
	private SubjectTypeEnum type;
	
	Student(String name, SubjectTypeEnum type){
		this.name = name;
		this.type = type;
		
	}
	
	public SubjectTypeEnum getType(){
		return this.type;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String toString(){
		
		return this.name + " " + this.type.toString();
	}
	
}
