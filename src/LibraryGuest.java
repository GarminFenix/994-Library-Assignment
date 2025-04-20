/* A class to represent a library guest. This class is a subclass of the abstract
 * super class Person. This class also has an additional data field to record the
 * access period a guest has.
 *
 * @author Ross Cochrane
 * @version 30/11/24
 */

public class LibraryGuest extends Person
{
    private int durationAccess;

    /**
     * Constructor for objects of class LibraryGuest with parameters
     */
    public LibraryGuest(String firstName, String lastName, String address,
                        int durationAccess)
    {
        super(firstName, lastName, address);
        setDurationAccess(durationAccess);
    }

    /**
     * Constructor for objects of class LibraryGuest with default values
     */
    public LibraryGuest()
    {
        super("DefaultFirstName", "DefaultLastName", "DefaultAddress");
        setDurationAccess(durationAccess);
    }

    public int getDurationAccess()
    {
        return durationAccess;
    }

    /**
     * Mutator to set library guest's duration of access. Access must not be
     * greater than 3 days.
     */
    public void setDurationAccess(int durationAccess)
    {
        if (durationAccess > 3 || durationAccess < 0){
            System.out.print("Error: Duration of access cannot be greater than 3 days or ");
            System.out.println("a negative value.");
        } else {
            this.durationAccess = durationAccess;
        }
    }

    /**
     * Method to print the details of a library guest
     */
    @Override
    public void printPersonDetails()
    {
        super.printPersonDetails();
        System.out.println("Duration of access: " + durationAccess +" days");

    }
}

