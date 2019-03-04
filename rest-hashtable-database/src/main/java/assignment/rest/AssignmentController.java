package assignment.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import assignment.model.Student;
import assignment.service.StudentService;
/**
 * Rest controller for CRUD controls
 * @author Doric
 *
 */
@RestController
@RequestMapping("/student")
public class AssignmentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/create")
	public ResponseEntity<?> createStudent(@RequestBody Student student){
		return studentService.createStudent(student);
	}
	
	@GetMapping("/read/{UUID}")
	public ResponseEntity<?> readStudent(@PathVariable("UUID") Integer UUID){
		return studentService.getStudent(UUID);
	}
	
	@PutMapping("/update/{UUID}")
	public ResponseEntity<?> updateStudent(@PathVariable("UUID") Integer UUID,@RequestBody Student student){
		return studentService.updateStudent(UUID,student);
	}
	
	@DeleteMapping("/delete/{UUID}")
	public ResponseEntity<?> deleteStudent(@PathVariable("UUID") Integer UUID){
		return studentService.deleteStudent(UUID);
	}

}
