package ec.edu.uce.controller;

import java.util.List;

import org.hibernate.cfg.Configuration;

import ec.edu.uce.models.PersonDAO;
import ec.edu.uce.models.Professor;
import ec.edu.uce.models.Schedule;
import ec.edu.uce.models.ScheduleDAO;
import ec.edu.uce.models.Student;
import ec.edu.uce.models.Subject;
import ec.edu.uce.models.SubjectDAO;

/**
 * @author Edgar Tipan
 */

public class Test {
	
	public void testApp() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Student.class);
		configuration.addAnnotatedClass(Professor.class);
		configuration.addAnnotatedClass(Subject.class);
		configuration.addAnnotatedClass(Schedule.class);

		PersonDAO personDAO = new PersonDAO(configuration);
		SubjectDAO subjectDAO = new SubjectDAO(configuration);
		ScheduleDAO scheduleDAO = new ScheduleDAO(configuration);

		Student student = new Student();
		student.setName("Alumno");
		student.setLastname("Primero");
		student.setAge(19);

		Professor profe = new Professor();
		profe.setName("Profesor");
		profe.setLastname("Primero");
		profe.setAge(30);
		
		Subject subject = new Subject();
		subject.setName("Programacion Avanzada II");
		subject.setDescription("Todo 2da");
		subject.setLevel(6);
		
		Schedule schedule = new Schedule();
		schedule.setSubjectId(1);
		schedule.setStudentId(1);
		schedule.setProfessorId(1);
		schedule.setStart_time("7:00");
		schedule.setEnd_time("9:00");
		schedule.setDay("Lunes");

		personDAO.createPerson(student);
		personDAO.createPerson(profe);
		subjectDAO.createSubject(subject);
		scheduleDAO.createSchedule(schedule);

		String name = "Pepe";

		List<Student> students = personDAO.getPersonsByName(name, Student.class);
		if (students.isEmpty()) {
			System.out.println("No se encontraron resultados que coincidan con el nombre: " + name);
		} else {
			for (Student stu : students) {
				System.out.println(stu.toString());
			}
		}
		
		personDAO.updatePersonFields(1, "Pepe", "Segundo", 19, Student.class);
		personDAO.updatePersonFields(1, "Profe", "Segundo", 30, Professor.class);
		subjectDAO.updateSubjectFields(1, "Programacion Avanzada II", "Todo 3ra", 6);
	}

}
