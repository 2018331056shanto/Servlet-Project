package com.Entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


//This class contains the table which has 4 column
// It has many to one relationship with Department and
// It has one to one relationship with User table 
//The column that stores the foreign key of Department is 
//departmentId and the column that stores the foreign key of 
// User table is userId
//This table contains the information about the teacher and
//in which department he is in 
@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "departmentId")
    private Department department;
    
    @OneToOne
    private User user;
    
	public Teacher(String id, String name, Department department, User user) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public int hashCode() {
		return Objects.hash(department, id, name, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		return Objects.equals(department, other.department) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", department=" + department + ", user=" + user + "]";
	}

	

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

    // getters and setters
}
