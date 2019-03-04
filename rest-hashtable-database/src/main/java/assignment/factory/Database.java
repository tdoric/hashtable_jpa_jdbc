package assignment.factory;

import assignment.exception.ZeroAffectedRowsException;
import assignment.model.Student;
/**
 * Abstract class of database with CRUD methods
 * @author Doric
 *
 */
public abstract class Database {
	
	public void  createStudent(Student student) {
	}
	public Student getStudent(Integer UUID) throws ZeroAffectedRowsException {
		return null;
	}
	public void deleteStudent(Integer UUID) throws ZeroAffectedRowsException {
	}
	public void updateStudent(Integer UUID,Student student) throws ZeroAffectedRowsException {
	}
}
