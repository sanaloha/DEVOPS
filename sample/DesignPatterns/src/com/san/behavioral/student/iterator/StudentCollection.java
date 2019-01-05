package com.san.behavioral.student.iterator;

public interface StudentCollection {
	
	public void addStudent(Student student);
	public void removeStudent(Student student);
	
	//create iterator
	public StudentIterator iterator(SubjectTypeEnum type);

}
