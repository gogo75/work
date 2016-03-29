/**
 * 
 */
package mysql;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author agorisse
 *
 */
public class CityTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Person p = new Person(3,"Franck","Delavaga","","");
		//insérer dans la BDD
		assertEquals("Le firstname n'est pas le bon !", "Franck", p.getFirstname());
		//ne pas oublier de supprimer la personne de la BDD sinon le test prendra le nouveau contexte
		//et on se fera avoir ! Le test ne se rejouera plus 
		fail("Not yet implemented");
	}

}
