package view_package;

import java.sql.SQLException;

import controller_package.Controller;

/**
 * @author Edgar Tipan
 */

public class Main {

	public static void main(String[] args) throws SQLException {
		
		//Configurar el puerto de conexion a SQL en la clase ConnectionClass antes de ejecutar

		Controller con = new Controller();
		con.databaseApp();

	}

}
