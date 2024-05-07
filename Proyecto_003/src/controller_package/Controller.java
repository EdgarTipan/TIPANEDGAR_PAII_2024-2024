package controller_package;

import java.sql.SQLException;

import model_package.Alumn;
import model_package.ConnectionClass;
import model_package.Professor;
import model_package.Schedule;
import model_package.Subject;

public class Controller {

	public void databaseApp() throws SQLException {
		
		ConnectionClass Conexion = new ConnectionClass();
		
		// Creamos un alumno
		Alumn alumno = new Alumn(1, "Alumno", "Primero", 21);

		// Metodo para crear la tabla
		alumno.createTable(Conexion.getConnection());

		// Insertamos un alumno en la db
		alumno.create(Conexion.getConnection(), alumno);
		alumno.read(Conexion.getConnection(),1);

		// -------------------------------------------------
		
		// Creamos un profesor
		Professor profesor = new Professor(1, "Profesor", "Primero", 30);

		// Metodo para crear la tabla
		profesor.createTable(Conexion.getConnection());

		// Insertamos un profesor en la db
		profesor.create(Conexion.getConnection(), profesor);
		
		// -------------------------------------------------

		// Creamos una materia
		Subject subject = new Subject(1, "Matematica", "Matematica basica", 1);

		// Metodo para crear la tabla
		subject.createTable(Conexion.getConnection());

		// Insertamos una materia en la db
		subject.create(Conexion.getConnection(), subject);
		
		// -------------------------------------------------
		
		// Creamos un horario
		Schedule sche = new Schedule(subject.getId(), alumno.getId(), profesor.getId(), "9", "11", "Lunes");
		
		// Creamos una tabla para los horarios
		sche.createTable(Conexion.getConnection());
		
		// Insertamos un horario en la db
		sche.create(Conexion.getConnection(), sche);

	}

}
