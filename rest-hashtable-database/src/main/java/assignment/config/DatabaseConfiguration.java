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

@Configuration
public class DatabaseConfiguration {
	
	Logger logger = LoggerFactory.getLogger(Application.class);
	@Autowired
	ImplementationFactory implementationFactory;
	@Bean
	public Database database() {
		return implementationFactory.createImplementation(random());
	}
	
	private DatabaseImplEnum random() {
		int pick = new Random().nextInt(DatabaseImplEnum.values().length);
		return DatabaseImplEnum.values()[pick];
	}

}
