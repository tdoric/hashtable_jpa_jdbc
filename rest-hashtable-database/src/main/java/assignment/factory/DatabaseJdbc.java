package assignment.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import assignment.exception.ZeroAffectedRowsException;
import assignment.jdbc.StudentJdbcRepo;
import assignment.model.Student;
/**
 * Subclasss of database for implementation Jdbc
 * @author Doric
 *
 */
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
			throw new ZeroAffectedRowsException("Zero affected rows");
		}
		
	}

	@Override
	public void deleteStudent(Integer UUID) throws ZeroAffectedRowsException {
		checkZeroAffectedRows(studentJdbcRepo.deleteStudent(UUID));
	}

	@Override
	public void updateStudent(Integer UUID, Student student) throws ZeroAffectedRowsException {
		checkZeroAffectedRows(studentJdbcRepo.updateStudent(UUID, student));
	}
	
	private void checkZeroAffectedRows(int affectedRows) throws ZeroAffectedRowsException {
		if(affectedRows==0) {
			throw new ZeroAffectedRowsException("Zero affected rows");
		}
	}
	
	

}
