package model_package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Edgar Tipan
 */

public class Schedule implements IDAOSchedule {

	private int id_subject;
	private int id_alumn;
	private int id_professor;
	private String start_time;
	private String end_time;
	private String day;
	private PreparedStatement ps;

	public Schedule(int id_mat, int id_alumno, int id_profesor, String start_time, String end_time, String day) {
		this.id_subject = id_mat;
		this.id_alumn = id_alumno;
		this.id_professor = id_profesor;
		this.start_time = start_time;
		this.end_time = end_time;
		this.day = day;
	}

	@Override
	public void create(Connection connection, Schedule schedule) throws SQLException {
		ps = connection.prepareStatement(
				"INSERT INTO Schedule (id_alumn, id_professor, id_subject, start_time,end_time, day) VALUES (?,?,?,?,?,?)");
		ps.setInt(3, schedule.getId_subject());
		ps.setInt(1, schedule.getId_alumn());
		ps.setInt(2, schedule.getId_professor());
		ps.setString(4, schedule.getStart_time());
		ps.setString(5, schedule.getEnd_time());
		ps.setString(6, schedule.getDay());
		ps.execute();
		ps.close();

	}

	@Override
	public Schedule read(Connection connection, Schedule schedule, int id_schedule) throws SQLException {
		ResultSet resultados = null;
		Schedule sche = new Schedule(0, 0, 0, "", "", "");

		ps = connection.prepareStatement("SELECT * FROM Schedule WHERE id = ?");
		ps.setInt(1, id_subject);
		resultados = ps.executeQuery();

		if (resultados.next()) {
			sche.setId_subject(resultados.getInt(1));
			sche.setId_alumn(resultados.getInt(2));
			sche.setId_professor(resultados.getInt(3));
			sche.setStart_time(resultados.getString(4));
			sche.setEnd_time(resultados.getString(5));
			sche.setDay(resultados.getString(6));

			System.out.println(sche.toString());
		}
		ps.execute();
		ps.close();
		return sche;
	}

	@Override
	public void update(Connection connection, Schedule schedule, int id_schedule) throws SQLException {
		ps = connection.prepareStatement(
				"UPDATE Schedule SET id_alumn=?, id_professor=?, id_subject=?, start_time=?, end_time=?, day=? WHERE id=?");
		ps.setInt(1, schedule.getId_alumn());
		ps.setInt(2, schedule.getId_professor());
		ps.setInt(3, schedule.getId_subject());
		ps.setString(4, schedule.getStart_time());
		ps.setString(5, schedule.getEnd_time());
		ps.setString(6, schedule.getDay());
		ps.execute();
		ps.close();
	}

	@Override
	public void delete(Connection connection, int id_schedule) throws SQLException {
		ps = connection.prepareStatement("DELETE FROM Schedule WHERE id=?");
		ps.setInt(1, id_schedule);
		ps.execute();
		ps.close();
	}

	@Override
	public void createTable(Connection connection) throws SQLException {
		String query = "CREATE TABLE IF NOT EXISTS Schedule ( " + "id_alumn INT," + "id_professor INT,"
				+ "id_subject INT," + "start_time VARCHAR(30)," + "end_time VARCHAR(30)," + "day VARCHAR(30),"
				+ "FOREIGN KEY (id_alumn) REFERENCES Alumns(id_alumn),"
				+ "FOREIGN KEY (id_professor) REFERENCES Professors(id),"
				+ "FOREIGN KEY (id_subject) REFERENCES Subject(id)" + ")";
		connection.createStatement().executeUpdate(query);
		System.out.println("Tabla creada o ya existente.");

	}

	public int getId_subject() {
		return id_subject;
	}

	public void setId_subject(int id_subject) {
		this.id_subject = id_subject;
	}

	public int getId_alumn() {
		return id_alumn;
	}

	public void setId_alumn(int id_alumn) {
		this.id_alumn = id_alumn;
	}

	public int getId_professor() {
		return id_professor;
	}

	public void setId_professor(int id_professor) {
		this.id_professor = id_professor;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "Schedule [id_subject=" + id_subject + ", id_alumn=" + id_alumn + ", id_professor=" + id_professor
				+ ", start_time=" + start_time + ", end_time=" + end_time + ", day=" + day + ", ps=" + ps + "]";
	}

}
