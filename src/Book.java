import java.util.ArrayList;
/**
 * A class to represent a book. This class is a subclass of the abstract
 * super class Resource and has an additional data field that maintains
 * a record of any damages to a book.
 *
 * @author Ross Cochrane
 * @version 30/11/24
 */

public class Book extends Resource
{
    private LibraryMember user;
    private ArrayList<String> damages;

    /**
     * Constructor for objects of class Book with parameters
     */
    public Book(String isbn, String title, Author author)
    {
        super(isbn, title, author);
        this.damages = new ArrayList<>();

    }

    /**
     * Constructor for objects of class Book with default values
     */
    public Book(Author author)
    {
        super("DefaultIsbn", "DefaultTitle", author);
        this.damages = new ArrayList<>();

    }

    public LibraryMember getUser()
    {
        return user;
    }

    public ArrayList getDamages()
    {
        return damages;
    }

    public void setUser(LibraryMember user)
    {
        this.user = user;
    }

    /**
     * Mutator to add damages
     */
    public void addDamage(String damage)
    {
        this.damages.add(damage);
    }

    /**
     * Method to print the details of a book
     */
    @Override
    public void printResourceDetails()
    {
        super.printResourceDetails();
        if (user != null){
            user.printPersonDetails();
        } else{
            System.out.println("There is no library member associated with this book");
        }
        System.out.println("Damages: " + damages);
    }

    /**
     * Method to check if a book is available
     */
    public boolean checkAvail()
    {
        if (user == null){
            return true;
        } else{
            return false;
        }
    }
}
