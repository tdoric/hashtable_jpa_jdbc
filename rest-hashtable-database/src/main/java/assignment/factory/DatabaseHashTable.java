package assignment.factory;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import assignment.config.HashTableProperties;
import assignment.exception.ZeroAffectedRowsException;
import assignment.hashtable.MyHashTable;
import assignment.model.Student;
/**
 * Subclass of database for implementation HashTable
 * @author Doric
 *
 */
@Component
public class DatabaseHashTable extends Database {
	
	@Autowired 
	MyHashTable<Integer, Student> myHashTable;
	@Autowired
	HashTableProperties hashTableProperties;
	private static Logger logger = LoggerFactory.getLogger(DatabaseHashTable.class);


	@Override
	public void createStudent(Student student) {
		int randomUUID = randomUUID();
		logger.info("UUID ="+randomUUID);
		myHashTable.put(randomUUID, student);
	}

	@Override
	public Student getStudent(Integer UUID) throws ZeroAffectedRowsException {
		checkZeroAffectedRows(UUID);
		return myHashTable.get(UUID);
	}

	@Override
	public void deleteStudent(Integer UUID) throws ZeroAffectedRowsException {
		checkZeroAffectedRows(UUID);
		myHashTable.remove(UUID);
	}

	@Override
	public void updateStudent(Integer UUID, Student student) throws ZeroAffectedRowsException {
		checkZeroAffectedRows(UUID);
		myHashTable.put(UUID, student);
	}
	
	private int randomUUID() {
		Random random = new Random();
		if(hashTableProperties.getSize()!=null) {
			return random.nextInt(hashTableProperties.getSize());
		}
		return random.nextInt(hashTableProperties.getNormal());
	}
	
	private void checkZeroAffectedRows(Integer UUID) throws ZeroAffectedRowsException {
		if(myHashTable.get(UUID)==null) {
			throw new ZeroAffectedRowsException("Zero affected rows");
		}
	}
	
	

}
