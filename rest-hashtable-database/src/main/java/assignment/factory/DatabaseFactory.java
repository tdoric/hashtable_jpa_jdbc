package assignment.factory;
/**
 * Abstract class for creator in application
 * @author Doric
 *
 * @param <E>
 */
public abstract class DatabaseFactory<E extends Enum<E>> {
		
		public abstract Database createImplementation(E nameEnum);
}
