package assignment.jdbc;

import assignment.model.Student;
/**
 * Interface for CRUD methods for JDBC implementation
 * @author Doric
 *
 */
public interface StudentJdbcRepo {
	
	public int createStudent(Student student);
	public Student getStudent(Integer UUID);
	public int deleteStudent(Integer UUID);
	public int updateStudent(Integer UUID,Student student);

}
