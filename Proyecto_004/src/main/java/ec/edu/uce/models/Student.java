package ec.edu.uce.models;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Edgar Tipan
 */

@Entity
@Table(name="Students")
public class Student extends Person{
	
	@Override
	public String toString() {
	    return "Student {" +
	        "Id: " + getId() +
	        ", Name: '" + getName() + '\'' +
	        ", Last Name: '" + getLastname() + '\'' +
	        ", Age: " + getAge() +
	        '}';
	}

}
