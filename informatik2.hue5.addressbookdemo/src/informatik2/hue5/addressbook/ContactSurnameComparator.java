package informatik2.hue5.addressbook;

import informatik2.hue5.addressbook.Contact;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class ContactSurnameComparator implements Comparator<Contact> 

// interface <generic> --> data type control by the compiler
// enables the programmer to write data types independent (generics) data structures and algorithm
// unnecessary casts can be avoided
{
	public int compare(Contact a, Contact b)
	{
		return a.getSurname().compareTo(b.getSurname());
	}
	
	// override
	// search after surname
	
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
//collator--> compares stringbuilder (special features of a language z.B.: Umlaute; capitalization and uncaptialization; ß-s)