package assignment.jdbc;
/**
 * SQL queries for JDBC implementation
 * @author Doric
 *
 */
public final class Statements {
	
	public static class Student{
		public static String SELECT = "select * from student where UUID=?";
		public static String UPDATE = "update student set name = ?, grade = ? where UUID = ?";
		public static String DELETE = "delete from student where UUID=?";
		public static String INSERT = "INSERT INTO STUDENT(name, grade) values(?, ?)";	
	}

}
