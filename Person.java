package mysql;

public class Person {
	private int id_city;
	private String firstname;
	private String lastname;
	private String emails;
	private String phone;
	
	public Person(){
		
	}
	
	public Person(int id_city, String firstname, String lastname, String emails, String phone) {
		super();
		//this.id_person = id_person;
		this.id_city = id_city;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emails = emails;
		this.phone = phone;
	}

	public int getId_city() {
		return id_city;
	}

	public void setId_city(int id_city) {
		this.id_city = id_city;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
