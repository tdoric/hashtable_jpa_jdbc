package assignment.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import assignment.model.Student;
/**
 * Implementation of CRUD controls for JDBC
 * @author Doric
 *
 */
@Repository
public class StudentJdbcRepoImpl implements StudentJdbcRepo {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int createStudent(Student student)  {
		return jdbcTemplate.update(Statements.Student.INSERT,
				new Object[] {student.getName(), student.getGrade() });
	}

	@Override
	public Student getStudent(Integer UUID) {
		return jdbcTemplate.queryForObject(Statements.Student.SELECT, new Object[] { UUID },
					new BeanPropertyRowMapper<Student>(Student.class));
		
	}

	@Override
	public int deleteStudent(Integer UUID){
		return jdbcTemplate.update(Statements.Student.DELETE, new Object[] { UUID });
		
	}

	@Override
	public int updateStudent(Integer UUID, Student student){
		return jdbcTemplate.update(Statements.Student.UPDATE,
				new Object[] { student.getName(), student.getGrade(), UUID });
		
	}

}
