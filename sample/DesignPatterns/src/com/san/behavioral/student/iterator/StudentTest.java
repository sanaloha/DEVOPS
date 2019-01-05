package com.san.behavioral.student.iterator;


/**
 * 1) Create a Student Class with name and subjectType
 * 2) Create a Student Collection class with below methods
 * 		-add(Student stud), remove(Student) and iterator(subjectType type)
 * 3) Create private student iterator class with below methods
 * 		-hasNext and Next 
 * 4) Create an enum subjectType
 * **/
public class StudentTest {

	public static void main(String[] args) {
		
		StudentCollection students = populateStudents();
		
		StudentIterator baseIterator = students.iterator(SubjectTypeEnum.ALL);
		
		while (baseIterator.hasNext()) {
			Student  stud = baseIterator.next();
			System.out.println(stud.toString());
		}
		System.out.println("================================");
		
		StudentIterator englishIterator = students.iterator(SubjectTypeEnum.ENGLISH);
		while (englishIterator.hasNext()) {
			Student stud = englishIterator.next();
			System.out.println(stud.toString());
		}
		
	
	}
	
	private static StudentCollection populateStudents() {
		StudentCollection collection = new StudentCollectionimpl();
		collection.addStudent((new Student("Amit", SubjectTypeEnum.ENGLISH)));
		collection.addStudent(new Student("shrikant", SubjectTypeEnum.HINDI));
		
		collection.addStudent(new Student("SAN", SubjectTypeEnum.ALL));
		
		return collection;
		
		}

}
