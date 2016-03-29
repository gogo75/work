package mysql;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class App {
	
	public static void main(String[] args) {
		Connection conn; 
		conn = JDBCManager.ouvrirConnection();
		/*Person*/
		PersonDAO pdao = new PersonDAO(conn);
		List<Person> arrayPerson = new ArrayList<>();
		List<City> arrayCity = new ArrayList<>();
		//Person p = new Person(2,"Golden", "Belette2", "goldenbelette@youtube.com","0202010103");
		Person p = new Person(3, "Franck", "Bobbynou", "ahahah@cestdrole.fr", "");
		/******** DECOMMENTER POUR EXECUTER ********/
		//pdao.insertPerson(p);
		//pdao.deletePerson(p);
		//pdao.getPersonById(5);
		//pdao.getAllPerson();
		
		for (int j = 0; j < pdao.getAllPerson().size(); j++) {
			System.out.println("Personne: " + pdao.getAllPerson().get(j).getFirstname()+ " " +
				pdao.getAllPerson().get(j).getLastname());
		}
		//pdao.getPersonByLastname("Bobbynou");
		
		/*City*/
		CityDAO cdao = new CityDAO();
		CityDAO.conn = conn;
		//City c = new City("Tomorrowland", "Guetta", 2000000, 55580);
		City c = new City("Fake ville", "pas de maire", 0, 2);
		//cdao.insertCity(c);
		//cdao.deleteCity(c);
		//cdao.getCityById(2);
		//createSeveralCities(3);
		
		cdao.getAllCity();
		for (int i = 0; i < cdao.getAllCity().size(); i++) {
			System.out.println("Ville: " + cdao.getAllCity().get(i).getName());
		}
		
		
		
		JDBCManager.fermerConnection();
	}
	
	/* Non entièrement fonctionnel */
	public static void createSeveralCities(int nb){
		Connection conn = JDBCManager.ouvrirConnection();
		for (int i = 0; i < nb; i++) {
			String nameCity = "Ville" + i;
			CityDAO cdao = new CityDAO();
			City c = new City(nameCity, "",0,0);
			cdao.insertCity(c);
			PersonDAO pdao = new PersonDAO(conn);
			//personnes 1 et 2
			Person p1 = new Person();
			p1.setFirstname(nameCity+"Nom1");
			p1.setLastname(nameCity+"Prenom1");
			Person p2 = new Person();
			p2.setFirstname(nameCity+"Nom2");
			p2.setLastname(nameCity+"Prenom2");
			//on les insère dans la BDD
			try {
				pdao.insertPerson(p1);
				pdao.insertPerson(p2);
			} catch (PersonException e) {
				e.getMessage();
			}
		}
	}
	
}	