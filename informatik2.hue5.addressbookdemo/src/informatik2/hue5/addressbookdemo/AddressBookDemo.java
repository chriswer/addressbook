package informatik2.hue5.addressbookdemo;

import java.util.GregorianCalendar;

import informatik2.hue5.addressbook.AddressBook;
import informatik2.hue5.addressbook.BusinessContact;
import informatik2.hue5.addressbook.PrivateContact;
import informatik2.hue5.addressbook.ContactGroup;
//Collection Framework

//the program AddressBookDemo exist to control the function from the class contact and addressbook

public class AddressBookDemo {

	public static void main(String[] args) {

		AddressBook myAddressBook = new AddressBook("myFirst Address-Book");
		// initialization

		myAddressBook.addContact(new BusinessContact("Max", "Muster",
				"Fooville", "maxi@student.at", "0123456789", "Pflaster Inc",
				"212 456 123", "http://google.com"));
		myAddressBook.addContact(new BusinessContact("Linda", "Payerl",
				"Barville", "linda@student.at", "01 555 456", "Frog Inc",
				"312 100 123", "http://belgacom.be"));
		myAddressBook.addContact(new BusinessContact("Kermit", "Frog", "Graz",
				"kermit@student.at", "10 12 14 16", "Commodo Inc",
				"412 156 123", "http://derstandard.at"));
		myAddressBook.addContact(new PrivateContact("Steve", "Travis",
				"Los Angeles", "travis@student.at", "555 910 567",
				new GregorianCalendar(1980, 5, 30)));
		myAddressBook.addContact(new PrivateContact("Albert", "Du Treuil",
				"Bruxelles", "albert@student.at", "0479 910 567",
				new GregorianCalendar(1974, 4, 20)));
		myAddressBook.addContact(new PrivateContact("Michi", "Schrempf"));
		// appeal constructor addressbook --> keyword new

		BusinessContact bc1 = new BusinessContact("Claudia", "Payerl", "Graz",
				"claudia@student.at", "045 555 019", "Prinzessin Inc",
				"212 456 123", "http://sueddeutsche.de");
		BusinessContact bc2 = new BusinessContact("Claudia", "Payerl", "Graz",
				"claudia@student.at", "045 555 019", "Prinzessin Inc",
				"212 456 123", "http://sueddeutsche.de");
		BusinessContact bc3 = new BusinessContact("Claudiaa", "Payerl", "Graz",
				"claudia@student.at", "045 555 019", "Prinzessin Inc",
				"212 456 123", "http://sueddeutsche.de");
		// equals

		System.out
				.println("\n\nContact Kathi:\n----------------------------------------");

		GregorianCalendar kathiBirthday = new GregorianCalendar(1992, 12, 18);
		PrivateContact kathi = new PrivateContact("Kathi", "Vorarlberg",
				kathiBirthday);
		kathi.print();
		kathi.setBirthdate(new GregorianCalendar(1992, 12, 14));
		kathi.print();
		myAddressBook.addContact(kathi);
		// private contact kathi

		System.out
				.println("\n\nTesting the equals-method:\n----------------------------------------");
		System.out.println("bc1 == bc2? " + bc1.equals(bc2));
		System.out.println("bc1 == bc3? " + bc1.equals(bc3));

		myAddressBook.addContact(bc1);
		myAddressBook.addContact(bc2);
		myAddressBook.addContact(bc3);

		// sorting by surname
		System.out.println("\n\nPrinting sorted by Surname:\n----------------------------------------");
		myAddressBook.printSortedBySurname();

		// sorting by firstname
		System.out.println("\n\nPrinting sorted by Firstname:\n----------------------------------------");
		myAddressBook.printSortedByFirstname();

		// saving to disk
		String filePath = "addressbook.csv";
		System.out.println("\n\nSaving to disk, filename: " + filePath);
		myAddressBook.exportContactsToFile(filePath);
		
		
		//create some groups
		System.out.println("\n\nContactGroups:\n----------------------------------------");
		ContactGroup cg1 = new ContactGroup("Tennis-Club", "Alle meine Tennis-Freunde");
		ContactGroup cg2 = new ContactGroup("Fussball-Freunde","WM-Begeisterte Freunde");
		
		cg1.addContact(kathi);
		cg1.addContact(bc1);
		
		cg2.addContact(bc1);
		cg2.addContact(kathi);
				
		myAddressBook.addGroup(cg1);
		myAddressBook.addGroup(cg2);
		
		myAddressBook.printGroups();

		/*
		 * // create some contacts... Contact person1 = new Contact("Max",
		 * "Muster", "Fooville", "maxi@student.at", "0123456789", "01.01.1900");
		 * Contact person2 = new Contact("Homer", "Simpson", "Evergreen Terace",
		 * "homer.s@springfield.com", "021304138", "12.05.1955"); Contact
		 * person3 = new Contact("Elvis", "Presley", "Tupelo, Mississippi",
		 * "elvis@theking.com", "05644231654", "08.01.1935");
		 * 
		 * // Test class method "printContacts" Contact someContacts[] =
		 * {person2, person3, person1};
		 * System.out.println("Test for class method: printContacts");
		 * System.out.println("----------------------------------------");
		 * AddressBook.printContacts(someContacts); System.out.println();
		 * 
		 * // create my Addressbook for 10 contacts AddressBook myAddressBook =
		 * new AddressBook("myFirst Address-Book", 10);
		 * myAddressBook.addContact(person1); myAddressBook.addContact(person2);
		 * myAddressBook.addContact(person3);
		 * 
		 * // new contact: not all fields are known Contact person4 = new
		 * Contact("Dagobert", "Duck");
		 * person4.setEMail("d.duck@entenhausen.com");
		 * System.out.println("print one contact: D. Duck");
		 * System.out.println("----------------------------------------");
		 * person4.print(); System.out.println();
		 * myAddressBook.addContact(person4); person4.setPhone("98765432100");
		 * // double entries ?? myAddressBook.addContact(person4);
		 * 
		 * System.out.println("\nPrint my entire addressbook:");
		 * System.out.println("----------------------------------------");
		 * System.out.println(myAddressBook.numOfContacts() +
		 * " contacts are stored in " + myAddressBook.getTitle());
		 * System.out.println(); myAddressBook.print();
		 * 
		 * // remove one contact from address book Contact personX = new
		 * Contact("Homer", "Simpson", "Evergreen Terace",
		 * "homer.s@springfield.com", "021304138", "12.05.1955");
		 * myAddressBook.removeContact(personX);
		 * myAddressBook.setTitle("My Private Addressbook");
		 * System.out.println("\nPrint my entire addressbook (after removeContact):"
		 * ); System.out.println("----------------------------------------");
		 * myAddressBook.print();
		 * 
		 * // Test address book lookup methods... System.out.println(
		 * "\nLook for contact in address book (and print contact):");
		 * System.out.println("----------------------------------------\n");
		 * Contact cont1; if ( (cont1 =
		 * myAddressBook.lookupByEmail("d.duck@entenhausen.com")) != null ) {
		 * System.out.println("nach lookupByEmail"); cont1.print();
		 * System.out.println(); } else
		 * System.out.println("nach lookupByEmail: contact not there");
		 * 
		 * if ( (cont1 = myAddressBook.lookupByName("Elvis", "Presley")) != null
		 * ) { System.out.println("nach lookupByName"); cont1.print();
		 * System.out.println(); } else
		 * System.out.println("nach lookupByName: contact not there");
		 * 
		 * if ( (cont1 = myAddressBook.lookupByName("Homer", "Simpson")) != null
		 * ) { System.out.println("nach lookupByName"); cont1.print();
		 * System.out.println(); } else
		 * System.out.println("nach lookupByName: contact not there");
		 */
	}
}
