package mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
	
	private Connection conn;
	
	public PersonDAO(Connection conn){
		this.conn = conn;
	}
	
	public void insertPerson(Person p) throws PersonException{
		// Construction de l'ordre SQL // ATTENTION : ON DOIT ENVOYER 0 POUR LA CLE PRIMAIRE
		// QUI EST EN AUTO_INCREMENT POUR QUE MYSQL PUISSE SE DEBROUILLER TOUT SEUL
		String ordre = "INSERT INTO Person VALUES " + "(0,'" + p.getId_city() + "','" + p.getFirstname() + "','" +
					p.getLastname() + "','" + p.getEmails() + "','" + p.getPhone() + "')";
		try {
			Statement statement = conn.createStatement();
			statement.executeUpdate(ordre);
			statement.close();
		} catch (SQLException expt) {
			throw new PersonException(p);
		} 
		System.out.println("Requête effectuée !");
	}
	
	public void deletePerson(Person p){
		String ordre = "DELETE FROM Person WHERE (id_city='" + p.getId_city() + "' AND firstname='" + p.getFirstname() +
				"' AND lastname='" + p.getLastname() + "' AND emails='" + p.getEmails() + "' AND phone='" + p.getPhone() + "')";
		try {
			Statement statement = conn.createStatement();
			statement.executeUpdate(ordre);
			statement.close();
		} catch (SQLException expt) {
			expt.printStackTrace();
		}
		System.out.println("Requête effectuée !");
	}
	
	public ArrayList<Person> getPersonById(int id){
		String ordre = "SELECT firstname, lastname FROM Person WHERE id_person='" + id + "'";
		ArrayList<Person> arrayPerson = new ArrayList<>();
		try {
			Statement statement;
			statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(ordre);
			while(rs.next()){
				Person p = new Person();
				p.setFirstname(rs.getString("firstname"));
				p.setLastname(rs.getString("lastname"));
				arrayPerson.add(arrayPerson.size(),p);
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayPerson;
	}
	
	public List<Person> getPersonByLastname(String lastname){
		String ordre = "SELECT firstname, lastname FROM Person WHERE lastname='" + lastname + "' ORDER BY firstname";
		List<Person> arrayPerson = new ArrayList<Person>();
		try {
			Statement statement;
			statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(ordre);
			while(rs.next()){
				Person p = new Person();
				p.setFirstname(rs.getString("firstname"));
				p.setLastname(rs.getString("lastname"));
				arrayPerson.add(arrayPerson.size(),p);
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayPerson;
	}
	
	public List<Person> getAllPerson(){
		String ordre = "SELECT firstname, lastname FROM Person";
		List<Person> arrayPerson = new ArrayList<>();
		try {
			Statement statement;
			statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(ordre);
			while(rs.next()){
				Person p = new Person();
				p.setFirstname(rs.getString("firstname"));
				p.setLastname(rs.getString("lastname"));
				arrayPerson.add(arrayPerson.size(),p);
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayPerson;
	}
	
}
