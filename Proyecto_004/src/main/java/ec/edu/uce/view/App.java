package ec.edu.uce.view;

import ec.edu.uce.controller.Frame;
import ec.edu.uce.controller.Test;

/**
 * @author Edgar Tipan
 */

public class App {
	
	public static void main(String[] args) {
		/*
		 *  FRAME CORRESPONDE A LA INTERFAZ (NO FINALIZADA). CONFIGURAR LAS CREDENCIALES DE LA DB SEGUN SEA NECESARIO
		 *  PROBAR CON TEST PARA COMPROBAR QUE LAS FUNCIONALIDADES DE LOS CRUD FUNCIONAN ADECUADAMENTE.
		 *  
		 *  EN EL ARCHIVO SQLSENTENCES DE LA CARPETA RESOURCES SE ENCUENTRAN 
		 *  LOS COMANDOS DE CREACION DE LAS TABLAS QUE SE USARAN.
		 */
		
		
//		Frame frame = new Frame();
//		frame.frameApp();
		
		Test test = new Test();
		test.testApp();
	}
	
}
