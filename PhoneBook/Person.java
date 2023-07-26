package PhoneBook;
/**
 * @author Joshua House
 * Person class that holds a name and a number
 */
public class Person extends KeyedItem<String> {
	private String name;
	private String number;
	/**
	 * 2 Parameter constructor that takes a name and a number, sets the name as the key, and the number to
	 * the number variable.
	 * @param name
	 * @param number
	 */
	public Person(String name, String number) {
		super(name);
		this.number = number;
		this.name = getKey();
	}// end person
	/**
	 * Gets the name of the person object
	 * @return name
	 */
	public String getName() {
		return this.name;
	}// end getName
	/**
	 * Gets the number of the person object
	 * @return number
	 */
	public String getNumber() {
		return this.number;
	}// end getNumber
	/**
	 * Sets the number as the inputted number
	 * @param number
	 */
	public void setNumber(String number) {
		this.number = number;
	}// end setNumber
	/**
	 * Overwritten toString method
	 */
	public String toString() {
		return name + "\t" + number;
	}// end toString
} // end of class
