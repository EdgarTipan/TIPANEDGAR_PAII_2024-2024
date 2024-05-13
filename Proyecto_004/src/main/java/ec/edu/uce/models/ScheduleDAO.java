package ec.edu.uce.models;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * @author Edgar Tipan
 */

public class ScheduleDAO {

	private SessionFactory sessionFactory;

	public ScheduleDAO(Configuration config) {
		sessionFactory = SessionFactorySingleton.getSessionFactory(config);
	}

	public void createSchedule(Schedule schedule) {
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();

			// Comprobar si las IDs existen
			Student student = session.get(Student.class, schedule.getStudentId());
			Professor professor = session.get(Professor.class, schedule.getProfessorId());
			Subject subject = session.get(Subject.class, schedule.getSubjectId());

			if (student != null && professor != null && subject != null) {
				// Si todas las IDs existen, persistir el Schedule
				session.persist(schedule);
				transaction.commit();
				System.out.println("Horario creado exitosamente");
			} else {
				// Si alguna de las IDs no existe, no crear el Schedule
				System.out.println("No se pudo crear el horario porque una o más de las IDs referenciadas no existen");
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Schedule> getAllSchedules() {
		List<Schedule> schedules = null;
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			Query<Schedule> query = session.createQuery("FROM Schedule", Schedule.class);
			schedules = query.list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return schedules;
	}

	public void updateSchedule(int id, int newSubjectId, int newStudentId, int newProfessorId, String newStartTime,
			String newEndTime, String newDay) {
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();

			// Comprobar si las IDs existen
			Student student = session.get(Student.class, newStudentId);
			Professor professor = session.get(Professor.class, newProfessorId);
			Subject subject = session.get(Subject.class, newSubjectId);

			if (student != null && professor != null && subject != null) {
				// Si todas las IDs existen, actualizar el Schedule
				Schedule schedule = session.get(Schedule.class, id);
				if (schedule != null) {
					schedule.setSubjectId(newSubjectId);
					schedule.setStudentId(newStudentId);
					schedule.setProfessorId(newProfessorId);
					schedule.setStart_time(newStartTime);
					schedule.setEnd_time(newEndTime);
					schedule.setDay(newDay);
					session.update(schedule);
					transaction.commit();
					System.out.println("Horario actualizado exitosamente");
				} else {
					System.out.println("No se encontró el horario especificado, no se pudo actualizar");
				}
			} else {
				// Si alguna de las IDs no existe, no actualizar el Schedule
				System.out.println(
						"No se pudo actualizar el horario porque una o más de las IDs referenciadas no existen");
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void deleteSchedule(int id) {
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			Schedule schedule = session.get(Schedule.class, id);
			if (schedule != null) {
				session.delete(schedule);
				transaction.commit();
				System.out.println("Horario eliminado exitosamente");
			} else {
				System.out.println("No se encontró el horario especificado, no se pudo eliminar");
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}
