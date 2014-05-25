package informatik2.hue3.addressbookdemo;

import informatik2.hue3.addressbookdemo.AddressBook;
import informatik2.hue3.addressbookdemo.Contact;


/**
 * Das Programm AddressBookDemo dient zur Überprüfung der Funktionalität
 * von Contact und AddressBook Klassen
 *
 */

public class AddressBookDemo {
 
    	public static void main(String[] args) {
                   	
           	// create some contacts...
           	Contact person1 = new Contact("Max", "Muster", "Fooville", "maxi@student.at", "0123456789", "01.01.1900");
           	Contact person2 = new Contact("Homer", "Simpson", "Evergreen Terace", "homer.s@springfield.com", "021304138", "12.05.1955");
           	Contact person3 = new Contact("Elvis", "Presley", "Tupelo, Mississippi", "elvis@theking.com", "05644231654", "08.01.1935");
                           	
           	// Test class method "printContacts"
           	Contact someContacts[] = {person2, person3, person1};
           	System.out.println("Test for class method: printContacts");
           	System.out.println("----------------------------------------");
           	AddressBook.printContacts(someContacts);
           	System.out.println();
 
           	// create my Addressbook for 10 contacts
           	AddressBook myAddressBook = new AddressBook("myFirst Address-Book", 10);
           	myAddressBook.addContact(person1);
           	myAddressBook.addContact(person2);
           	myAddressBook.addContact(person3);
 
           	// new contact: not all fields are known
           	Contact person4 = new Contact("Dagobert", "Duck");
           	person4.setEmail("d.duck@entenhausen.com");
           	System.out.println("print one contact: D. Duck");
           	System.out.println("----------------------------------------");
           	person4.print();
           	System.out.println();
           	myAddressBook.addContact(person4);
           	person4.setTelnum("98765432100");
           	// double entries ??
           	myAddressBook.addContact(person4);
           	
           	System.out.println("\nPrint my entire addressbook:");
           	System.out.println("----------------------------------------");
           	System.out.println(myAddressBook.numOfContacts() + " contacts are stored in " + myAddressBook.getTitle());
           	System.out.println();
           	myAddressBook.print();
           	
           	// remove one contact from address book
           	Contact personX = new Contact("Homer", "Simpson", "Evergreen Terace", "homer.s@springfield.com", "021304138", "12.05.1955");
           	myAddressBook.removeContact(personX);
           	myAddressBook.setTitle("My Private Addressbook");
           	System.out.println("\nPrint my entire addressbook (after removeContact):");
           	System.out.println("----------------------------------------");
           	myAddressBook.print();
           	
           	// Test address book lookup methods...
           	System.out.println("\nLook for contact in address book (and print contact):");
           	System.out.println("----------------------------------------\n");
           	Contact cont1;
           	if ( (cont1 = myAddressBook.lookupByEmail("d.duck@entenhausen.com")) != null ) {
                   	System.out.println("nach lookupByEmail"); 	
                   	cont1.print();
                   	System.out.println();
           	}
           	else
                   	System.out.println("nach lookupByEmail: contact not there");
           	
           	if ( (cont1 = myAddressBook.lookupByName("Elvis", "Presley")) != null ) {
                   	System.out.println("nach lookupByName");
                   	cont1.print();
                   	System.out.println();
    	    	}
           	else
                   	System.out.println("nach lookupByName: contact not there");
           	
           	if ( (cont1 = myAddressBook.lookupByName("Homer", "Simpson")) != null ) {
                   	System.out.println("nach lookupByName");
                   	cont1.print();
                   	System.out.println();
           	}
           	else
                   	System.out.println("nach lookupByName: contact not there");      	
    	}
 
}
