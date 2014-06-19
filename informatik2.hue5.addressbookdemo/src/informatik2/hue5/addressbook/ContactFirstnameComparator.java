package informatik2.hue5.addressbook;

import informatik2.hue5.addressbook.Contact;
import java.util.Comparator;


public class ContactFirstnameComparator implements Comparator<Contact> {
	
	// generics --> data type control by the compiler
	// enables the programmer to write data types independent (generics) data structures and algorithm
	// unnecessary casts can be avoided

	public int compare(Contact a, Contact b) {
		int x = a.getFirstname().compareTo(b.getFirstname());

		if (x == 0) {

			int y = a.getSurname().compareTo(b.getSurname());
			return y;
		}

		return x;
	}
	
	// override
	// when firstname is the same then == 0, either compare surname
	// no else, because } 
	// search after firstname
}