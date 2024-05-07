package model_package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Edgar Tipan
 */

public class Professor extends Person implements IDAOPerson {

	private PreparedStatement ps;

	public Professor(int id, String name, String lastName, int age) {
		super(id, name, lastName, age);

	}

	@Override
	public void create(Connection connection, Person person) throws SQLException {
		ps = connection.prepareStatement("INSERT INTO Professors (id, name, lastname, age) VALUES (?,?,?,?)");
		ps.setInt(1, person.getId());
		ps.setString(2, person.getName());
		ps.setString(3, person.getLastName());
		ps.setInt(4, person.getAge());
		ps.execute();
		ps.close();

	}

	@Override
	public void read(Connection c, int id_person) throws SQLException {

		Professor profe = new Professor(0, "", "", 0);

		String sql = "SELECT * FROM Professors WHERE id = ?";
		ps = c.prepareStatement(sql);
		ps.setInt(1, id_person);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			profe.setId(rs.getInt(1));
			profe.setName(rs.getString(2));
			profe.setLastName(rs.getString(3));
			profe.setAge(rs.getInt(4));
		}

		System.out.println(profe.toString());

		ps.execute();
		ps.close();

	}

	@Override
	public void update(Connection connection, Person person, int id_person) throws SQLException {
		ps = connection.prepareStatement("UPDATE Professors SET name=?, lastname=?, age=? WHERE id=?");
		ps.setString(1, person.getName());
		ps.setString(2, person.getLastName());
		ps.setInt(3, person.getAge());
		ps.setInt(4, id_person);
		ps.execute();
		ps.close();

	}

	@Override
	public void delete(Connection connection, int id_person) throws SQLException {
		ps = connection.prepareStatement("DELETE FROM Professors WHERE id=?");
		ps.setInt(1, id_person);
		ps.execute();
		ps.close();

	}

	@Override
	public void createTable(Connection connection) throws SQLException {
		String query = "CREATE TABLE IF NOT EXISTS Professors ( " + "id INT PRIMARY KEY," + "name VARCHAR(35),"
				+ "lastname VARCHAR(30)," + "age INT" + ")";
		connection.createStatement().executeUpdate(query);
		System.out.println("Tabla creada o ya existente.");
	}

}
