package openjpa.person.api;
import java.util.List;

public interface PersonService {
	void add(int id, String name);
	Person find(int id);
	Person delete(int id);
	//List<Person> findAll();
}
