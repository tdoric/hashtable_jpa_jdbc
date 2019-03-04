package assignment.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import assignment.hashtable.MyHashTable;
import assignment.model.Student;

/**
 * Configuration class for my own implementation of HashTable
 * @author Doric
 *
 */
@Configuration
public class HashtableConfiguration {
	
	private static Logger logger = LoggerFactory.getLogger(HashtableConfiguration.class);
	
	@Autowired
	HashTableProperties hashTableProperties;
	/**
	 * Method for creating Bean MyHashtable<K,V>
	 * @return new MyHashtable with capacity if capacity is greater then 1 and 
	 * @return new Hashtable with standard capacity if input parameter for capacity is 0 
	 * or IllegalArgumentException is catched
	 * 
	 */
	@Bean
	public MyHashTable<Integer, Student> myHashTable(){
		if(hashTableProperties.getSize()!=null) {
			  try {
		        	return new MyHashTable<Integer, Student>(hashTableProperties.getSize());
		        }catch (IllegalArgumentException e) {
		        	logger.info("IllegalArgumentException");
		        	return new MyHashTable<Integer, Student>();
				}
		}
		return new MyHashTable<Integer, Student>(); 
      
	}
	
	

}
