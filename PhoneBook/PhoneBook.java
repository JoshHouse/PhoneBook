package PhoneBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * @author Joshua House
 * PhoneBook class that holds a Binary search tree with methods to fill the tree, add, remove, retrieve, save
 * and display the tree
 */
public class PhoneBook {
	private BinarySearchTree<Person, String> PhoneTree;
	/**
	 * Default constructor that initializes the PhoneTree
	 */
	public PhoneBook() {
		PhoneTree = new BinarySearchTree<Person, String>();
	}// end PhoneBook
	/**
	 * Adds a person to the tree
	 * @param input       A person object
	 */
	public void add(Person input) {
		PhoneTree.insert(input);
	} // end add
	/**
	 * Takes the name of the person and returns their name and phone number
	 * @param Name
	 * @return Person object with given name from the tree
	 */
	public Person retrieve(String Name) {
		return PhoneTree.retrieve(Name);
	} // end retrieve
	/**
	 * Deletes the person with the given name from the tree
	 * @param Name
	 * @throws TreeException
	 */
	public void delete(String Name) throws TreeException {
		PhoneTree.delete(Name);
	}// end delete
	/**
	 * Reads from the file and fills the tree with the people from the text file
	 */
	public void fillTree() {
		int index;
		String input, name, number;
		Scanner fileInput;
		File inFile = new File("assg9_phoneBook.txt");
		
		try {
			fileInput = new Scanner(inFile);
			while(fileInput.hasNextLine()) {
				input = fileInput.nextLine();
				index = input.indexOf("\t");
				name = input.substring(0, index);
				number = input.substring(index + 1);
				PhoneTree.insert(new Person(name, number));
			}// End try
			fileInput.close();
		} catch (FileNotFoundException e) {
			System.out.print("Input file was not found");
			System.exit(1);
		}// End catch
	} // End fillTree
	/**
	 * Saves the tree back to the file
	 */
	public void save() {
		try {
			PrintWriter output = new PrintWriter("assg9_phoneBook.txt");
			TreeIterator<Person> treeItr = new TreeIterator<Person>(PhoneTree);
			treeItr.setInorder();
			while (treeItr.hasNext()) {
				output.println(treeItr.next());
			}// end while
			output.close();
			
		} catch (FileNotFoundException e) {
			System.out.print("Input file was not found.");
			System.exit(1);
		}// end catch
	}// End save
	/**
	 * Sorts the tree and displays the people in order by name
	 */
	public void DisplaySorted() {
		TreeIterator<Person> treeItr = new TreeIterator<Person>(PhoneTree);
		treeItr.setInorder();
		while (treeItr.hasNext()) {
			System.out.println(treeItr.next());
		}// end while
	} // end displaySorted
} // end of class
 