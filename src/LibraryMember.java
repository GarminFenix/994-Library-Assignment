import java.util.ArrayList;

/**
 * A class to represent a library member. This class is a subclass of the abstract
 * super class Person. This class also maintains a record of what books a member has
 * borrowed and what electronic resources they have accessed.
 *
 * @author Ross Cochrane
 * @version 30/11/24
 */

public class LibraryMember extends Person
{
    private String id;
    private ArrayList<Book> borrowed;
    private ArrayList<EResource> accessed;
    private Library library;

    /**
     * Constructor for objects of class LibraryMember with parameters
     */
    public LibraryMember(String firstName, String lastName, String address, String id, Library library)
    {
        super(firstName, lastName, address);
        this.id = id;
        this.borrowed = new ArrayList<>();
        this.accessed = new ArrayList<>();
        if (library == null){
            System.out.println("Error: libray cannot be null. Please associate a libary with the library member.");
        } else{
            this.library = library;
        }
    }

    /**
     * Constructor for objects of class LibraryMember with default values
     */
    public LibraryMember(Library library)
    {
        super("DefaultFirstName", "DefaultLastName", "DefaultAddress");
        this.id = "DefaultId";
        this.borrowed = new ArrayList<>();
        this.accessed = new ArrayList<>();
        this.library = library;

    }

    public ArrayList getBorrowed()
    {
        return borrowed;
    }

    public ArrayList getAccessed()
    {
        return accessed;
    }

    public String getId()
    {
        return id;
    }

    public Library getLibrary()
    {
        return library;
    }

    public void setId(String id)
    {
        if (id == null){
            System.out.println("Error: null value entered");
        } else{
            this.id = id;
        }
    }

    public void setLibrary(Library library)
    {
        if (library == null){
            System.out.println("Error: null value entered");
        } else{
            this.library = library;
        }
    }

    /**
     * Method to add a book to a library member's borrowed list
     */
    public void addBorrowedBook(Book book)
    {
        if (book == null){
            System.out.println("Error: there are no books to add!");
            return;
        } else if (borrowed.contains(book)) {
            System.out.println("This book is already out on loan to the library member!");
            return;
        } else if (library == null || !library.getResources().contains(book)){
            System.out.println("Error: this book is not in the library's catalogue. Please try again.");
            return;
        } else{
            borrowed.add(book);
            book.setUser(this);
            System.out.println("Book successfully added to member's borrowed list");
        }
    }

    /**
     * Method to keep a record of electronic resources accessed by the library member.
     */
    public void addAccessedEResource(EResource eresource)
    {
        if (eresource == null){
            System.out.println("Error: there are no electronic resources to add!");
            return;
        } else if (library == null || !library.getResources().contains(eresource)){
            System.out.println("Error: this electronic resource is not in the library's catalogue. Please try again.");
            return;
        } else{
            accessed.add(eresource);
            System.out.println("Electronic resource successfully added to member's accessed record.");
        }
    }

    /**
     * Method to remove a book from a library member's borrowed list
     */
    public void removeBorrowedBook(Book book)
    {
        if (book == null){
            System.out.println("Error: there are no books to remove!");
            return;
        } else if (borrowed.contains(book)) {
            borrowed.remove(book);
            book.setUser(null);
            System.out.println("Book successfully removed from member's borrowed list");
        } else if (!(borrowed.contains(book))){
            System.out.println("Error: book not found in member's borrowed list!");
        }
    }

    /**
     * Method to print the details of a library member
     */
    @Override
    public void printPersonDetails()
    {
        super.printPersonDetails();
        System.out.println("Library member ID: " + id);
    }

    /**
     * Method to print details of all the books currently borrowed by a library member
     */
    public void printBorrowed()
    {
        int index = 0;
        while(index < borrowed.size()){
            Book currentBook = borrowed.get(index);
            currentBook.printResourceDetails();
            index++;
        }
        if (index == 0){
            System.out.println("No books currently borrowed by member");
        }

    }

    /**
     * Method to print details of all the electronic resources accessed by the library member
     */
    public void printAccessed()
    {
        int index = 0;
        while(index < accessed.size()){
            EResource currentEResource = accessed.get(index);
            currentEResource.printResourceDetails();
            index++;
        }
        if (index == 0){
            System.out.println("No electronic resources have been accessed by member");
        }

    }

    /**
     * Method to return the number of books currently borrowed by a library member
     */
    public int numBorrowed()
    {
        int num = borrowed.size();
        return num;

    }
}
