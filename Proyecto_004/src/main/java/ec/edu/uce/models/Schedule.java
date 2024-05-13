package ec.edu.uce.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Edgar Tipan
 */

@Entity
@Table(name="Schedules")
public class Schedule {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    
	@Column(name="subject_id")
	private int subjectId;
	
	@Column(name="student_id")
	private int studentId;
	
	@Column(name="professor_id")
	private int professorId;

	@Column(name="start_time")
	private String start_time;
	
	@Column(name="end_time")
	private String end_time;
	
	@Column(name="day")
	private String day;

	public Schedule() {
	}

	public Schedule(int id, int subjectId, int studentId, int professorId, String start_time, 
			String end_time, String day) {
		this.id = id;
		this.subjectId = subjectId;
		this.studentId = studentId;
		this.professorId = professorId;
		this.start_time = start_time;
		this.end_time = end_time;
		this.day = day;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int professorId) {
		this.professorId = professorId;
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
		return "Schedule {Id: " + id + ", Subject Id: " + subjectId + ", Student Id: " + studentId + ", Professor Id: "
				+ professorId + ", Start Time: " + start_time + ", End Time: " + end_time + ", Day: " + day + "}";
	}
	
}
