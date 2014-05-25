package informatik2.hue4.addressbookdemo;

import java.util.List;
import java.util.Collections;
import java.util.LinkedList;
import java.io.FileWriter;
import java.io.IOException;

import informatik2.hue4.addressbookdemo.Contact;
import informatik2.hue4.addressbookdemo.ContactFirstnameComparator;
import informatik2.hue4.addressbookdemo.ContactSurnameComparator;




public class AddressBook
{
	//Member-Variablen
	private String title = "";
	//private int maxSize = 0;
	//private int size = 0;
	//private Contact[] contacts = null;
	private List<Contact> contacts = new LinkedList<Contact>();
	
	
	//Getter und Setter
	public void setTitle(String title)
	{
		this.title = title;
	}

    public String getTitle()
    {
       return this.title;
    }
    
   /* public void setMaxSize(int maxSize)
	{
		this.maxSize = maxSize;
	}

    public int getmaxize()
    {
       return this.maxSize;
    }*/
    
    
    
    //---------------------------------------------------------------------------------------------------
    // Konstruktor
    //---------------------------------------------------------------------------------------------------
	public AddressBook (String title) //, int maxSize) 
	{
		this.title = title;
		//this.maxSize = maxSize;
		//this.size = 0;
		//this.contacts = new Contact[this.maxSize];
		
	}
	
	
	
	//---------------------------------------------------------------------------------------------------
    // Statische Methode
    //---------------------------------------------------------------------------------------------------
	public static void printContacts (List<Contact> contacts) 
	{
		for (Contact c: contacts)
			c.print();
	}
		
	
	
	//---------------------------------------------------------------------------------------------------
    // Methoden
    //---------------------------------------------------------------------------------------------------
	public void addContact (Contact c) 
	{
		this.contacts.add(c);
	}

	
	public void removeContact (Contact c) 
	{
		this.contacts.remove(c);
	}
	
	
	public int numOfContacts () 
	{
		return this.contacts.size();
	}

	
	public void print () 
	{
		AddressBook.printContacts(this.contacts);
	}
	
	
	public void exportContactsToFile (String filePath)
	{
		try
		{
		    FileWriter writer = new FileWriter(filePath);
	 
		    writer.append("Vorname;Nachname;Adresse;eMail;Telefonnummer;Geburtsdatum;Firmenbezeichnung;FaxNummer;Firmen-WebSite\n");
		    
		    for (Contact c: this.contacts)
		    {
		    	writer.append(c.toCsv());
		    	writer.append('\n');
		    }
		    
		    writer.flush();
		    writer.close();
		}
		
		catch(IOException e)
		{
		     e.printStackTrace();
		}
	}
	
	
	public void printSortedByFirstname () 
	{
		Collections.sort(this.contacts,new ContactFirstnameComparator());
		this.print();
	}
	
	
	public void printSortedBySurname () 
	{
		Collections.sort(this.contacts,new ContactSurnameComparator());
		this.print();
	}
}
