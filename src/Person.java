/**
 * An abstract class called Person that encapsulates the common attributes of library
 * guest, library member and author classes. These common attributes include the data
 * fields of first name, last name and address, and a method to print the details of
 * a person.
 * Transposed into IntelliJ from Bluejay
 *
 * @author Ross Cochrane
 * @version 25/01/25
 */

public class Person
{

    protected String firstName;
    protected String lastName;
    protected String address;

    public Person(String firstName, String lastName, String address)
    {
     this.firstName = firstName;
     this.lastName = lastName;
     this.address = address;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getAddress()
{
    return address;
}

    public void setFirstName(String firstName)
    {
        if (firstName == null){
            System.out.println("Error. Null value entered. Please try again.");
            return;
        } else{
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName)
    {
        if (lastName == null){
            System.out.println("Error. Null value entered. Please try again.");
            return;
        } else{
            this.lastName = lastName;
        }
    }

    public void setAddress(String address)
    {
        if (address == null){
            System.out.println("Error. Null value entered. Please try again.");
            return;
        } else{
            this.address = address;
        }
    }

    /**
     * Method to print the details of a person
     */
    public void printPersonDetails()
    {
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Address: " + address);
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
        if (!(obj instanceof Person)){
            return false;
        }
        Person person = (Person) obj;
        return  firstName.equals(person.firstName) &&
                lastName.equals(person.lastName) &&
                address.equals(person.address);
    }

    /**
     * Method to override the hashcode
     */
    @Override
    public int hashCode()
    {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }

}
