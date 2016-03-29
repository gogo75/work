package mysql;

public class City {
	//private int id_city;
	private String name;
	private String mayor;
	private int inhabitants;
	private int zipcode;
	
	public City(){
		
	}
	
	public City(String name, String mayor, int inhabitants, int zipcode) {
		super();
		this.name = name;
		this.mayor = mayor;
		this.inhabitants = inhabitants;
		this.zipcode = zipcode;
	}


	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	
	public String getMayor() {
		return mayor;
	}

	
	public void setMayor(String mayor) {
		this.mayor = mayor;
	}

	
	public int getInhabitants() {
		return inhabitants;
	}

	
	public void setInhabitants(int inhabitants) {
		this.inhabitants = inhabitants;
	}

	
	public int getZipcode() {
		return zipcode;
	}

	
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	
	
}
