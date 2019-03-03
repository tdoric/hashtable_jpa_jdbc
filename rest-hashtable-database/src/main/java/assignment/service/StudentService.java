package assignment.service;

import org.springframework.http.ResponseEntity;

import assignment.model.Student;

public interface StudentService {
	
	public ResponseEntity<?> createStudent(Student student);
	public ResponseEntity<?> getStudent(Integer UUID);
	public ResponseEntity<?> deleteStudent(Integer UUID);
	public ResponseEntity<?> updateStudent(Integer UUID,Student student);

}
