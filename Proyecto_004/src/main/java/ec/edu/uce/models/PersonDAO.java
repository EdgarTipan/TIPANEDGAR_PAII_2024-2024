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

public class PersonDAO{

    private SessionFactory sessionFactory;

    public PersonDAO(Configuration config) {
        sessionFactory = SessionFactorySingleton.getSessionFactory(config);
    }

    public void createPerson(Person person) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public <T extends Person> List<T> getPersonsByName(String name, Class<T> type) {
        List<T> persons = null;
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Query<T> query = session.createQuery("FROM " + type.getSimpleName() + " WHERE name = :name", type);
            query.setParameter("name", name);
            persons = query.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return persons;
    }


    public <T extends Person> void updatePersonFields(int id, String newName, String newLastname, int newAge, Class<T> type) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            
            T person = session.get(type, id);
            if (person != null) {
                person.setName(newName);
                person.setLastname(newLastname);
                person.setAge(newAge);
                session.update(person);
                transaction.commit();
                System.out.println("Persona actualizada exitosamente");
            }else {
            	System.out.println("No se encontro la persona especificada, no se pudo actualizar");
            }
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public <T extends Person> void deletePerson(int id, Class<T> type) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            
            T person = session.get(type, id);
            if (person != null) {
                session.delete(person);
                transaction.commit();
                System.out.println("Persona borrada exitosamente");
            } else {
            	System.out.println("No se encontro la persona especificada, no se pudo borrar");
            }
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

}
