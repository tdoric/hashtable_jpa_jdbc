package assignment.factory;

public abstract class DatabaseFactory<E extends Enum<E>> {
		
		public abstract Database createImplementation(E nameEnum);
}
