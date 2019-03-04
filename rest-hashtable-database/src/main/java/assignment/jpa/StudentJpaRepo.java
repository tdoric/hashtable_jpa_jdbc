package assignment.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import assignment.model.Student;
/**
 * Interface for CRUD controls JPA
 * @author Doric
 *
 */
@Repository
public interface StudentJpaRepo extends JpaRepository<Student, Integer> {

}
