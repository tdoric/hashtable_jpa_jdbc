package assignment.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/***
 * Class for mapping properties from hashtable.properties
 * @author Doric
 *
 */
@ConfigurationProperties(prefix = "hashtable")
@PropertySource("classpath:hashtable.properties")
@Configuration("hashTableProperties")
public class HashTableProperties {
	
	private Integer size;
	private int normal;

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public int getNormal() {
		return normal;
	}

	public void setNormal(int normal) {
		this.normal = normal;
	}
	
}
