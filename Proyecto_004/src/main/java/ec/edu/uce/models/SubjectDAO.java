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

public class SubjectDAO {

	private SessionFactory sessionFactory;

	public SubjectDAO(Configuration config) {
		sessionFactory = SessionFactorySingleton.getSessionFactory(config);
	}

	public void createSubject(Subject subject) {
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			session.persist(subject);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Subject> getSubjectsByName(String name) {
		List<Subject> subjects = null;
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			Query<Subject> query = session.createQuery("FROM Subject WHERE name = :name", Subject.class);
			query.setParameter("name", name);
			subjects = query.list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return subjects;
	}

	public void updateSubjectFields(int id, String newName, String newDescription, int newLevel) {
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();

			Subject subject = session.get(Subject.class, id);
			if (subject != null) {
				subject.setName(newName);
				subject.setDescription(newDescription);
				subject.setLevel(newLevel);
				session.update(subject);
				transaction.commit();
				System.out.println("Asignatura actualizada exitosamente");
			} else {
				System.out.println("No se encontro la asignatura especificada, no se pudo actualizar");
			}

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void deleteSubject(int id) {
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();

			Subject subject = session.get(Subject.class, id);
			if (subject != null) {
				session.delete(subject);
				transaction.commit();
				System.out.println("Asignatura borrada exitosamente");
			} else {
				System.out.println("No se encontro la asignatura especificada, no se pudo borrar");
			}

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}
