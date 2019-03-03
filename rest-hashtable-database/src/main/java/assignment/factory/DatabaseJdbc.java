package assignment.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import assignment.exception.ZeroAffectedRowsException;
import assignment.jdbc.StudentJdbcRepo;
import assignment.model.Student;

@Component
public class DatabaseJdbc extends Database {
	
	@Autowired
	StudentJdbcRepo studentJdbcRepo;

	@Override
	public void createStudent(Student student) {
		studentJdbcRepo.createStudent(student);
	}

	@Override
	public Student getStudent(Integer UUID) throws ZeroAffectedRowsException {
		
		try {
			return studentJdbcRepo.getStudent(UUID);
		}catch(EmptyResultDataAccessException e) {
			throw new ZeroAffectedRowsException("");
		}
		
	}

	@Override
	public void deleteStudent(Integer UUID) throws ZeroAffectedRowsException {
		studentJdbcRepo.deleteStudent(UUID);
	}

	@Override
	public void updateStudent(Integer UUID, Student student) throws ZeroAffectedRowsException {
		studentJdbcRepo.updateStudent(UUID, student);
	}
	
	

}
