/**
 * A class to represent an electronic resource, such as an online journal.
 * This class is a subclass of the abstract super class Resource. This class also
 * contains an additional data field to display the downloaded status of an
 * electronic resource.
 *
 * @author Ross Cochrane
 * @version 30/11/24
 */
public class EResource extends Resource
{
    private boolean downloaded;

    /**
     * Constructor for objects of class EResource with parameters
     */
    public EResource(String isbn, String title, Author author, boolean downloaded)
    {
        super(isbn, title, author);
        this.downloaded = downloaded;
    }

    /**
     * Constructor for objects of class EResource with default values
     */
    public EResource(Author author)
    {
        super("DefaultIsbn", "DefaultTitle", author);
        downloaded = false;
    }

    public boolean getDownloaded()
    {
        return downloaded;
    }

    public void setdownloaded(boolean downloaded)
    {
        this.downloaded = downloaded;
    }

    /**
     * Method to print the details of an EResource
     */
    @Override
    public void printResourceDetails()
    {
        super.printResourceDetails();
        System.out.println("Download status of electronic resoure: " + downloaded);

    }
}
