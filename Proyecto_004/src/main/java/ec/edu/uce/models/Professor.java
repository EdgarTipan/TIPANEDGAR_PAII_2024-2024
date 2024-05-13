package ec.edu.uce.models;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Edgar Tipan
 */

@Entity
@Table(name="Professors")
public class Professor extends Person{
	
	@Override
	public String toString() {
	    return "Professor {" +
	        "Id: " + getId() +
	        ", Name: '" + getName() + '\'' +
	        ", Last Name: '" + getLastname() + '\'' +
	        ", Age: " + getAge() +
	        '}';
	}

}
