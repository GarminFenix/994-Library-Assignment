public class Main {
    public static void main(String[] args)
    {
       Library library1 = new Library();
       Author author1 = new Author();
       Author author2 = new Author();
       LibraryMember lm1 = new LibraryMember(library1);
       LibraryMember lm2 = new LibraryMember(library1);
       LibraryGuest lg1 = new LibraryGuest();
       Book book1 = new Book(author1);
       Book book2 = new Book(author2);
       EResource er1 = new EResource(author1);
       EResource er2 = new EResource(author2);
       library1.addResource(book1);
       library1.addResource(er1);
       library1.checkCatalogue(book1);
       library1.editResource(book1,"name2");
       book1.printResourceDetails();
       book1.addDamage("fucked");
       book1.printResourceDetails();
       library1.checkCatalogue(book1);



    }
}