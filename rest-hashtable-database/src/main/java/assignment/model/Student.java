package assignment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer UUID;
	String name;
	Integer grade;
	 
	public Student() {
		super();
	}
	
	public Student(Integer uUID, String name, Integer grade) {
		super();
		UUID = uUID;
		this.name = name;
		this.grade = grade;
	}
	
	public Student(String name, Integer grade) {
		super();
		this.name = name;
		this.grade = grade;
	}
	
	
	public Integer getUUID() {
		return UUID;
	}

	public void setUUID(Integer uUID) {
		UUID = uUID;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return String.format("Student [UUID=%s, name=%s, grade=%s]", UUID, name, grade);
	}
	
	
	

}
