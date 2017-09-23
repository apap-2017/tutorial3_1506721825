package com.example.tutorial3.service;

import java.util.List;

import com.example.tutorial3.model.StudentModel;
import java.util.ArrayList;


public class InMemoryStudentService implements StudentService {

	private static List<StudentModel> studentList = new ArrayList<>();
	
	@Override
	public StudentModel selectStudent(String npm) {
		
		for (StudentModel e : studentList) {
			if (e.getNpm().equals(npm))
				return e;
		}
		
		return null;
	}

	@Override
	public List<StudentModel> selectAllStudents() {
		return studentList;
	}

	@Override
	public void addStudent(StudentModel student) {
		studentList.add(student);

	}

}
