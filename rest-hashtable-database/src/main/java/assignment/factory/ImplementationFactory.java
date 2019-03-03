package assignment.factory;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import assignment.enums.DatabaseImplEnum;

@Component
public class ImplementationFactory extends DatabaseFactory<DatabaseImplEnum> {
	
	Logger logger = LoggerFactory.getLogger(ImplementationFactory.class);
	@Autowired
	DatabaseJpa databaseJpa;
	@Autowired
	DatabaseJdbc databaseJdbc;
	@Autowired
	DatabaseHashTable databaseHashTable;

	@Override
	public Database createImplementation(DatabaseImplEnum nameEnum) {
		logger.info("Using: " + nameEnum);
		switch (nameEnum) {
		case JPA_IMPLEMENATION:
			return databaseJpa;
		case JDBC_IMPLEMENTATION:
			return databaseJdbc;
		case HASHTABLE_IMPLEMENTATION:
			return databaseHashTable;
		default:
			throw new IllegalArgumentException("No such database implementation.");
		}
		
	}



}
