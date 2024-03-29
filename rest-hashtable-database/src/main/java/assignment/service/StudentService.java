package assignment.service;

import org.springframework.http.ResponseEntity;

import assignment.model.Student;
/**
 * Interface service for CRUD controls
 * @author Doric
 *
 */
public interface StudentService {
	
	public ResponseEntity<?> createStudent(Student student);
	public ResponseEntity<?> getStudent(Integer UUID);
	public ResponseEntity<?> deleteStudent(Integer UUID);
	public ResponseEntity<?> updateStudent(Integer UUID,Student student);

}
