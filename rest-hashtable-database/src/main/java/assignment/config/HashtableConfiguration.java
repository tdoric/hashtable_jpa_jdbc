package assignment.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import assignment.hashtable.MyHashTable;
import assignment.model.Student;

@Configuration
public class HashtableConfiguration {
	Logger logger = LoggerFactory.getLogger(HashtableConfiguration.class);
	@Autowired
	HashTableProperties hashTableProperties;
	@Bean
	public MyHashTable<Integer, Student> myHashTable(){
		if(hashTableProperties.getSize()!=0) {
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
