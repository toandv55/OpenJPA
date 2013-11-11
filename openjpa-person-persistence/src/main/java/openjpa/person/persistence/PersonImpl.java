package openjpa.person.persistence;

import javax.persistence.Entity;
import javax.persistence.*;
import openjpa.person.api.*;

@Entity(name = "persons")
public class PersonImpl implements Person {
    
	@Id
	@Column(length=9, name="person_id")
	private int id;
	@Column(length=50, name="person_name")
	private String name;
	
	public PersonImpl() {
	}
	
	public PersonImpl(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
}
