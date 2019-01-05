package com.san.behavioral.student.iterator;

import java.util.ArrayList;
import java.util.List;

public class StudentCollectionimpl implements StudentCollection {
	
	private List<Student> list;
	
	StudentCollectionimpl(){
		this.list = new ArrayList();
	}

	@Override
	public void addStudent(Student student) {
		this.list.add(student);

	}

	@Override
	public void removeStudent(Student student) {
		this.list.remove(student);

	}

	@Override
	public StudentIterator iterator(SubjectTypeEnum type) {
		
		return new IteratorImpl(this.list, type);
	}
	
	private class IteratorImpl implements StudentIterator{
		
		private List<Student> students;
		private SubjectTypeEnum subjType;
		private int index;
		
		
		IteratorImpl(List<Student> list, SubjectTypeEnum type){
			this.students = list;
			this.subjType = type;
		}

		@Override
		public boolean hasNext() {
			
			while(index < students.size() ){
				Student student = students.get(index);
				if(student.getType().equals(this.subjType) || subjType.equals(SubjectTypeEnum.ALL)){
				
					return true;
				}
				else
					index++;
			}
			
			return false;
		}

		@Override
		public Student next() {

			Student stud = students.get(index);
			index++;
			return stud;
		}
	}
}
