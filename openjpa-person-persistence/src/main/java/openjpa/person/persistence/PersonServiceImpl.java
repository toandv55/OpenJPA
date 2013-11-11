package openjpa.person.persistence;

import javax.persistence.EntityManager;
import openjpa.person.api.PersonService;
import openjpa.person.api.Person;

public class PersonServiceImpl implements PersonService {
	private EntityManager em;
	
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void add(int id, String name) {
		PersonImpl person = new PersonImpl(id, name); 
		em.persist(person);
		em.flush();
	}
	
	@Override
	public Person find(int id) {
		Person person = em.find(PersonImpl.class, id);
		return person;
	}
	
	@Override
	public Person delete(int id) {
		return null;
	}
}