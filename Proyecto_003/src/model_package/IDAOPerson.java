package model_package;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *  @author Edgar Tipan
 */

public interface IDAOPerson {
	
	public void create(Connection connection, Person person) throws SQLException;

	public void read(Connection connection, int id_person) throws SQLException;

	public void update(Connection connection,  Person person, int id_person)throws SQLException;

	public void delete(Connection connection, int id_person)throws SQLException;
	
	public void createTable(Connection connection) throws SQLException;


}
