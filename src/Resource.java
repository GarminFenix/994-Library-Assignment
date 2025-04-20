import java.util.UUID;
/**
 * An abstract class called Resource that encapsulates common attributes of the
 * book and EResource classes. These common attributes include data fields such as
 * a unique Id, ISBN, Title and Author, and a method to print the details of a
 * resource.
 *
 * @author Ross Cochrane
 * @version 2/12/24
 */
public abstract class Resource
{
    private final String uniqueId;
    protected String isbn;
    protected String title;
    protected Author author;

    /**
     * Constructor for objects of class Resource
     */
    public Resource(String isbn, String title, Author author)
    {
        this.uniqueId = UUID.randomUUID().toString();
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getUniqueId(){
        return uniqueId;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public String getTitle()
    {
        return title;
    }

    public Author getAuthor()
    {
        return author;
    }

    public void setIsbn(String isbn)
    {
        if (isbn == null){
            System.out.println("Error. Null value entered. Please try again.");
            return;
        } else{
            this.isbn = isbn;
        }
    }

    public void setTitle(String title)
    {
        if (title == null){
            System.out.println("Error. Null value entered. Please try again.");
            return;
        } else{
            this.title = title;
        }
    }

    public void setAuthor(Author author)
    {
        if (author == null){
            System.out.println("Error. Null value entered. Please try again.");
            return;
        } else{
            this.author = author;
        }
    }

    /**
     * Method to print the details of a resource
     */
    public void printResourceDetails()
    {
        System.out.println("Unique ID: " + uniqueId);
        System.out.println("ISBN: " + isbn);
        System.out.println("Title: " + title);
        if (author != null){
            author.printPersonDetails();
        } else{
            System.out.println("There is no author for this resource.");
        }
    }

    /**
     * Method to override equals from object class
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Resource resource = (Resource) obj;
        return uniqueId.equals(resource.uniqueId);
    }

    /**
     * Method to override hashcode
     */
    @Override
    public int hashCode()
    {
        return uniqueId.hashCode();
    }
}
