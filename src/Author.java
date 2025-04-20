
/**
 * A class to represent an author. This class is a subclass of the abstract
 * super class Person.
 *
 * @author Ross Cochrane
 * @version 30/11/24
 */
public class Author extends Person
{
    /**
     * Constructor for objects of class Author with parameters
     */
    public Author(String firstName, String lastName, String address)
    {
        super(firstName, lastName, address);
    }

    /**
     * Constructor for objects of class Author with default values
     */
    public Author()
    {
        super("DefaultFirstName", "DefaultLastName", "DefaultAddress");
    }
}