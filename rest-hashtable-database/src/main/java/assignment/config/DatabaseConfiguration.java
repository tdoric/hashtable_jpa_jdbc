package assignment.config;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import assignment.enums.DatabaseImplEnum;
import assignment.factory.Database;
import assignment.factory.ImplementationFactory;
import assignment.main.Application;
/**
 * Configuration class for implementation of database 
 * @author Doric
 *
 */
@Configuration
public class DatabaseConfiguration {
	
	private static Logger logger = LoggerFactory.getLogger(Application.class);
	@Autowired
	ImplementationFactory implementationFactory;
	
	/**
	 * Method for creating bean Database
	 * Input of ImplementationFactory  is DatabaseImplEnum
	 * @return
	 */
	@Bean
	public Database database() {
		return implementationFactory.createImplementation(random());
	}
	
	
	/***
	 * Random enum generator
	 * @return
	 */
	private DatabaseImplEnum random() {
		int pick = new Random().nextInt(DatabaseImplEnum.values().length);
		logger.info("I' pick "+DatabaseImplEnum.values()[pick]);
		return DatabaseImplEnum.values()[pick];
	}

}
