package mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CityDAO {
	City c = new City();
	static Connection conn;
	
	public void insertCity(City c){
		// Construction de l'ordre SQL // ATTENTION : ON DOIT ENVOYER 0 POUR LA CLE PRIMAIRE
		// QUI EST EN AUTO_INCREMENT POUR QUE MYSQL PUISSE SE DEBROUILLER TOUT SEUL
		String ordre = "INSERT INTO City VALUES " + "(0,'" + c.getName() + "','" + c.getMayor() + "','" +
					c.getInhabitants() + "','" + c.getZipcode() + "')";
		try {
			// Instanciation d'un objet Statement
			Statement statement = conn.createStatement();
			// Exécution de l'ordre SQL
			statement.executeUpdate(ordre);
			statement.close();
		} catch (SQLException expt) {
			expt.printStackTrace();
		}
		System.out.println("Requête effectuée !");
	}

	public void deleteCity(City c){
		String ordre = "DELETE FROM City WHERE (name='" + c.getName() + "' AND mayor='" + c.getMayor() +
				"' AND inhabitants='" + c.getInhabitants() + "' AND zipcode='" + c.getZipcode() + "')";
		try {
			// Instanciation d'un objet Statement
			Statement statement = conn.createStatement();
			// Exécution de l'ordre SQL
			statement.executeUpdate(ordre);
			statement.close();
		} catch (SQLException expt) {
			expt.printStackTrace();
		}
		System.out.println("Requête effectuée !");
	}
	
	public ArrayList<City>  getCityById(int id){
		String ordre = "SELECT name FROM City WHERE id_city='" + id + "'";
		ArrayList<City> arrayCity = new ArrayList<>();
		try {
			Statement statement;
			statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(ordre);
			while(rs.next()){
				City c = new City();
				c.setName(rs.getString("name"));
				arrayCity.add(arrayCity.size(),c);
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayCity;
	}
	
	public ArrayList<City>  getCityByName(String name){
		String ordre = "SELECT name FROM City WHERE name='" + name + "'";
		ArrayList<City> arrayCity = new ArrayList<>();
		try {
			Statement statement;
			statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(ordre);
			while(rs.next()){
				City c = new City();
				c.setName(rs.getString("name"));
				arrayCity.add(arrayCity.size(),c);
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayCity;
	}
	
	public ArrayList<City>  getAllCity(){
		String ordre = "SELECT name FROM City";
		ArrayList<City> arrayCity = new ArrayList<>();
		try {
			Statement statement;
			statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(ordre);
			while(rs.next()){
				City c = new City();
				c.setName(rs.getString("name"));
				arrayCity.add(arrayCity.size(),c);
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayCity;
	}
}
