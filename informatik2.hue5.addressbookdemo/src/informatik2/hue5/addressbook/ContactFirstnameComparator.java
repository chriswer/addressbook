package informatik2.hue5.addressbook;

import informatik2.hue5.addressbook.Contact;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

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
	
private static void compare(Collator col, String string, String string2) {
		
	}
	
	public static void main()
	{
		Collator col = Collator.getInstance(Locale.GERMAN);
		
		System.out.println( "Strength = PRIMARY");
		col.setStrength(Collator.PRIMARY);
		compare (col, "abc", "ABC");
		compare (col, "Quäken" , "Quaken");
		compare (col, "boß" , "boss");
		
		System.out.printf( "%nStrength = SECONDARY%n");
		col.setStrength(Collator.SECONDARY);
		compare (col, "abc", "ABC");
		compare (col, "Quäken" , "Quaken");
		compare (col, "boß" , "boss");
		
		System.out.printf( "%nStrength = TERTIARY%n");
		col.setStrength(Collator.TERTIARY);
		compare (col, "abc", "ABC");
		compare (col, "Quäken" , "Quaken");
		compare (col, "boß" , "boss");
	}
	
}
// collator--> compares stringbuilder (special features of a language z.B.: Umlaute; capitalization and uncaptialization; ß-s)
