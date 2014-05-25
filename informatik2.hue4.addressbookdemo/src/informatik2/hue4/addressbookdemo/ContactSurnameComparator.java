package informatik2.hue4.addressbookdemo;

import informatik2.hue4.addressbookdemo.Contact;
import java.util.Comparator;


public class ContactSurnameComparator implements Comparator<Contact> 
{
	@Override
	public int compare(Contact a, Contact b)
	{
		return a.getSurname().compareTo(b.getSurname());
	}
}
