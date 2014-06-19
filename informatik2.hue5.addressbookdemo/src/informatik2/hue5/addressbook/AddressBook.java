package informatik2.hue5.addressbook;

import java.util.List;
import java.util.Collections;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// Collection Framework


import informatik2.hue5.addressbook.Contact;
import informatik2.hue5.addressbook.ContactFirstnameComparator;
import informatik2.hue5.addressbook.ContactSurnameComparator;

public class AddressBook {

	private String title = "";
	// private int maxSize = 0;
	// private int size = 0;
	// private Contact[] contacts = null;
	private List<Contact> contacts = new LinkedList<Contact>();

	// member variables
	// visibility of the class (private --> can only be used within this class)
	// generics -->

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	// getter and setter methods
	// controls from outside (interface) whether specific criteria are fulfilled

	// public void setMaxSize(int maxSize) { this.maxSize = maxSize; }
	//public int getmaxize() { return this.maxSize; }

	public AddressBook(String title) // , int maxSize)
	{
		this.title = title;
		// this.maxSize = maxSize;
		// this.size = 0;
		// this.contacts = new Contact[this.maxSize];

	}
	// constructor--> defined a objects
	// name of the constructor = name of the class
	
	public static void main(String[]arg) throws Exception {
			
			BufferedReader CSVFile = new BufferedReader (new FileReader ("addressbook.csv"));
			String dataRow = CSVFile.readLine();
			while (dataRow != null) {
				String [] dataArray = dataRow.split(",");
				for (String item:dataArray) {
					System.out.print(item + "\t");
				}
			System.out.println();
			dataRow = CSVFile.readLine();
			}
			CSVFile.close();
			System.out.println();
	 }
	

	public static void printContacts(List<Contact> contacts) {
		for (Contact c : contacts)
			c.print();
	}

	// static method--> you have not to define the object, it is possible to
	// define it in the class

	public void addContact(Contact c) {
		if (!this.contacts.contains(c))
			this.contacts.add(c);
	}

	// controls whether distinct contact elements exist
	// control of duplicates

	public void removeContact(Contact c) {
		this.contacts.remove(c);
	}

	// delete contacts

	public int numOfContacts() {
		return this.contacts.size();
	}

	public void print() {
		AddressBook.printContacts(this.contacts);
	}

	// method

	public void exportContactsToFile(String filePath) {
		try {
			FileWriter writer = new FileWriter(filePath);

			writer.append("Vorname;Nachname;Adresse;eMail;Telefonnummer;Geburtsdatum;Firmenbezeichnung;FaxNummer;Firmen-WebSite\n");

			for (Contact c : this.contacts) {
				writer.append(c.toCsv());
				writer.append('\n');
			}

			writer.flush();
			writer.close();
			//
		}

		catch (IOException e) {
			e.printStackTrace();
			// IOException--> to deal flexible with errors
			// stacktrace--> the virtual machine remembers a stack, which method
			// calls up another method
			// it is useful in case of error, because you can see the cause of the error
		}
	}

	// filewriter--> produced an output current and appends the file to an existed file

	
	public void printSortedByFirstname() {
		Collections.sort(this.contacts, new ContactFirstnameComparator());
		this.print();
	}

	// sort after firstname

	public void printSortedBySurname() {
		Collections.sort(this.contacts, new ContactSurnameComparator());
		this.print();
	}
}

// sort after surname