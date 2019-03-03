package assignment.jdbc;

import assignment.exception.ZeroAffectedRowsException;
import assignment.model.Student;

public interface StudentJdbcRepo {
	
	public int createStudent(Student student);
	public Student getStudent(Integer UUID);
	public int deleteStudent(Integer UUID) throws ZeroAffectedRowsException;
	public int updateStudent(Integer UUID,Student student) throws ZeroAffectedRowsException;

}
