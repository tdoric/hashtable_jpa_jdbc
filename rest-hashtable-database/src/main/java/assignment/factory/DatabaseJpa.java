package assignment.factory;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import assignment.jpa.StudentJpaRepo;
import assignment.model.Student;

@Component
public class DatabaseJpa extends Database {
	
	@Autowired
	StudentJpaRepo studentJpaRepo;

	@Override
	public void createStudent(Student student) {
		studentJpaRepo.save(student);
	}

	@Override
	public Student getStudent(Integer UUID) {
		
		return studentJpaRepo.getOne(UUID);
	}

	@Override
	public void deleteStudent(Integer UUID) {
		studentJpaRepo.deleteById(UUID);
	}

	@Override
	public void updateStudent(Integer UUID, Student student) {
		Student studentToUpdate = studentJpaRepo.getOne(UUID);
		studentToUpdate.setGrade(student.getGrade());
		studentToUpdate.setName(student.getName());
		studentJpaRepo.save(studentToUpdate);
		
	}
	
	

}
