package mysql;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {

	@Before
	public void setUp() throws Exception {
		JDBCManager.ouvrirConnection();
	}

	@After
	public void tearDown() throws Exception {
		JDBCManager.fermerConnection();
	}

	@Test
	public void testInsertPerson() {
		Person p = new Person(3, "Franck", "Bobbynou", "ahahah@cestdrole.fr", "");
		PersonDAO pdao = new PersonDAO(JDBCManager.getConn());
		try {
			pdao.insertPerson(p);
			List<Person> personnes = pdao.getPersonByLastname("Bobbynou");
			assertEquals("Les deux entrées sont différentes", p.getLastname(), personnes.get(0).getLastname());
			pdao.deletePerson(p);
		} catch (PersonException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void insertPerson2(){
		PersonDAO pdao = new PersonDAO(JDBCManager.getConn());
		Person p = new Person(3, "Franck", "Bobbynou", "ahahah@cestdrole.fr", "");
		List<Person> personnes = pdao.getAllPerson();
		int taille = personnes.size();
		try {
			pdao.insertPerson(p);
			assertEquals("Pas ajouté", taille, personnes.size());
			pdao.deletePerson(p);
		} catch (PersonException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void deletePerson(){
		PersonDAO pdao = new PersonDAO(JDBCManager.getConn());
		
	}
}
