import java.util.ArrayList;

/**
 * A class to represent a library. This class is a management class and is
 * responsible for adding, removing and searching for resources in its collection.
 * The library also keeps track of which resources are borrowed by members and
 * possesses data fields such as name, address, phone number and email.
 *
 * @author Ross Cochrane
 * @version 30/11/24
 */

public class Library
{
    private ArrayList<Resource> resources;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private int count;

    /**
     * Constructor for objects of class Library with parameters
     */
    public Library(String name, String address, String email, String phoneNumber)
    {
        this.resources = new ArrayList<>();
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.count = 0;
    }

    /**
     * Constructor for objects of class Library with default values
     */
    public Library()
    {
        this.resources = new ArrayList<>();
        name = "DefaultName";
        address = "DefaultAddress";
        email = "DefaultEmail";
        phoneNumber = "DefaultNumber";
        count = 0;
    }

    public ArrayList getResources()
    {
        return resources;
    }

    public String getName()
    {
        return name;
    }

    public String getAddress()
    {
        return address;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public int getCount()
    {
        return count;
    }

    public void setName(String name)
    {
        if (name == null){
            System.out.println("Error: null value entered. Please try again.");
            return;
        } else{
            this.name = name;
        }
    }

    public void setAddress(String address)
    {
        if (address == null){
            System.out.println("Error: null value entered. Please try again.");
            return;
        } else{
            this.address = address;
        }
    }

    public void setEmail(String email)
    {
        if (email == null){
            System.out.println("Error: null value entered. Please try again.");
            return;
        } else{
            this.email = email;
        }
    }

    public void setPhoneNumber(String phoneNumber)
    {
        if (email == null){
            System.out.println("Error: null value entered. Please try again.");
            return;
        } else{
            this.phoneNumber = phoneNumber;
        }
    }

    /**
     * Method to print the details of a library
     */
    public void printLibraryDetails()
    {
        System.out.println("Library Name: " + name);
        System.out.println("Library address: " + address);
        System.out.println("Library email " + email);
    }

    /**
     * Method to check if the library resource contains a resource
     */

    public boolean checkCatalogue(Resource resource)
    {
        if (resource == null){
            System.out.println("Error: null value entered. Please try again.");
        }
        if (resources.contains(resource)){
            return true;
        } else{
            return false;
        }
    }

    /**
     * Method to edit the author's first name of a resource.
     */
    public void editResource(Resource resource, String newName)
    {
        if (resource == null){
            System.out.println("Error: null value entered. Please try again.");
            return;
        } else if(!getResources().contains(resource)){
            System.out.println("Error: resource is not in catalogue.");
        } else{
            Author author = resource.getAuthor();
            if (author != null){
                author.setFirstName(newName);
            } else{
                System.out.println("The resource does not have an associated author.");
            }
        }
    }

    /**
     * Method to search the library catalogue by resource title.
     */
    public void titleSearch(String search)
    {
        count = 0;
        for (Resource resource : resources){
            if(resource.getTitle().equalsIgnoreCase(search)){
                resource.printResourceDetails();
                count +=1;
            }
        }
        System.out.println("Number of resources found: " + count);
    }

    /**
     * Method to search the library catalogue by last name.
     */
    public void lastNameSearch(String lastName)
    {
        count = 0;
        for (Resource resource : resources){
            Author author = resource.getAuthor();
            if(author != null && author.getLastName().equalsIgnoreCase(lastName)){
                resource.printResourceDetails();
                count +=1;
            } else if( author == null){
                System.out.println("Author data field for this resource is null");
            }
        }
        System.out.println("Number of resources found: " + count);
    }

    /**
     * Method to remove a resource from the library catalogue.
     */
    public void removeObj(Resource resource)
    {
        if (resource == null){
            System.out.println("Error: null value entered. Please try again.");
            return;
        } else{
            if (resources.contains(resource)){
                if (resource instanceof Book){
                    Book book = (Book) resource;
                    LibraryMember user = book.getUser();
                    if (user == null){
                        resources.remove(resource);
                        System.out.println(resource + " has been removed from the catalogue");
                    } else{
                        System.out.println("This resource is currently on loan");
                    }
                } else if (resource instanceof EResource){
                    resources.remove(resource);
                    System.out.println(resource + " has been removed from the catalogue");
                }
                else{
                    System.out.println("This resource is not in the catalogue");
                }
            }
        }
    }

    /**
     * Method to remove a resource at a specific position in the catalogue.
     */
    public void removePos(int index)
    {
        if (index >= 0 && index < resources.size()){
            Resource resource = resources.get(index);
            if (resource instanceof Book){
                Book book = (Book) resource;
                LibraryMember user = book.getUser();
                if (user == null){
                    resources.remove(index);
                    System.out.println(resource + " has been removed from position " + index + " of the catalogue");
                } else{
                    System.out.println("This resource is currently on loan");
                }
            } else{
                resources.remove(index);
                System.out.println(resource + " has been removed from position " + index + " of the catalogue");
            }
        } else{
            System.out.println("Specified position does not exist in the catalogue");
        }
    }

    /**
     * A method to print the details of all the available books not currently on loan
     */
    public void printAvailBooks()
    {
        count = 0;
        for (Resource resource : resources){
            if (resource instanceof Book){
                Book book = (Book) resource;
                LibraryMember user = book.getUser();
                if (user == null){
                    count += 1;
                    book.printResourceDetails();
                }
            }
        }
        if (count == 0){
            System.out.println("There are no available books in the library");
        }
    }

    /**
     * A method to return the number of resources in the library catalogue
     */
    public int numResources()
    {
        int num = resources.size();
        return num;
    }

    /**
     * A method to append a resource to the catalogue after checking if it is already there. If there, it rejects it.
     */
    public void addResource(Resource resource)
    {
        count = 0;
        if (resource == null){
            System.out.println("Error: null value entered. Please try again.");
        } else{
            if (resources.contains(resource)){
                System.out.println("This resource already exists in the catalogue");
            } else{
                resources.add(resource);
                count += 1;
                System.out.println(count + " resource appended to the catalogue");
            }
        }
    }

    /**
     * A method to simulate the process of lending a book
     */
    public void loanBook(Book book, LibraryMember libraryMember)
    {
        if (book == null){
            System.out.println("Error: null value entered. Please try again.");
            return;
        } else{
            LibraryMember user = book.getUser();
            if(!(resources.contains(book))){
                System.out.println("Error: This book is not in the catalogue");
            } else if (!(user == null)){
                System.out.println("This book is already out on loan");
            } else {
                book.setUser(libraryMember);
                libraryMember.addBorrowedBook(book);
                System.out.println("Book has been successfully loaned");
            }
        }
    }

    /**
     * A method to simulate the process of accepting a book return
     */
    public void returnBook(Book book, Boolean isDamage, String damage)
    {
        if (book == null){
            System.out.println("Error: null value entered. Please try again.");
            return;
        } else{
            LibraryMember user = book.getUser();
            if(!(resources.contains(book))){
                System.out.println("Error: This book is not in the catalogue");
            } else if(user == null){
                System.out.println("Error: This book is not currently recorded as out on loan");
            } else{
                book.setUser(null);
                user.removeBorrowedBook(book);
                System.out.println("Book return accepted!");
                if (isDamage == true){
                    book.addDamage(damage);
                    System.out.println("Damages added to damage record");
                }
            }
        }
    }

    /**
     * A method to print the details of all books in the catalogue
     */
    public void printBooksDetails()
    {
        for (Resource resource : resources){
            if(resource instanceof Book){
                Book book = (Book) resource;
                book.printResourceDetails();
            }
        }
    }

    /**
     * A method to print the details of all electronic resources in the catalogue
     */
    public void printEResourcesDetails()
    {
        for (Resource resource : resources){
            if (resource instanceof EResource){
                EResource eresource = (EResource) resource;
                eresource.printResourceDetails();
            }
        }
    }
}


