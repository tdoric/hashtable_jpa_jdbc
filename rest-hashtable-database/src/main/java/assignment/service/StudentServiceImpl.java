package assignment.service;



import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import assignment.exception.ZeroAffectedRowsException;
import assignment.factory.Database;
import assignment.model.Student;
/**
 * Implementation of CRUD controls in service layer
 * @author Doric
 *
 */
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	Database database;
	
	@Override
	public ResponseEntity<?> createStudent(Student student) {
	    database.createStudent(student);
	    return ResponseEntity.ok("Insert confirmed.");
	}

	@Override
	public ResponseEntity<?> getStudent(Integer UUID) {
        try {
        	 Student student  = database.getStudent(UUID);
        	 return ResponseEntity.ok( student.toString());
        }catch(ZeroAffectedRowsException|EntityNotFoundException e){
        	return  ResponseEntity.notFound().build();
        }
	}

	@Override
	public ResponseEntity<?> deleteStudent(Integer UUID) {
		try {
			database.deleteStudent(UUID);
			return ResponseEntity.ok("Remove confirmed");
		}catch(EntityNotFoundException|EmptyResultDataAccessException|ZeroAffectedRowsException e){
        	return  ResponseEntity.notFound().build();
        }
		
	}

	@Override
	public ResponseEntity<?> updateStudent(Integer UUID, Student student) {
		try {
			database.updateStudent(UUID, student);
			return ResponseEntity.ok("Update confirmed.");
		}catch(EntityNotFoundException|EmptyResultDataAccessException|ZeroAffectedRowsException e){
        	return  ResponseEntity.notFound().build();
        }
		
	}
	
	

}
