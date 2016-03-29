package mysql;


public class PersonException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PersonException(Person p) {
		super();
		if(p.equals(null)){
			System.out.println("Je ne connais pas cette personne...");
		}
	}
}