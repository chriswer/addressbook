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
import informatik2.hue5.addressbook.AddressBookItem;
import informatik2.hue5.addressbook.ContactFirstnameComparator;
import informatik2.hue5.addressbook.ContactSurnameComparator;

public class AddressBook {

	private String title = "";
	// private int maxSize = 0;
	// private int size = 0;
	// private Contact[] contacts = null;
	private List<AddressBookItem> items = new LinkedList<AddressBookItem>();

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
	

	public static void printContacts(List<AddressBookItem> items) {
		for (AddressBookItem a : items)
			a.print();
	}

	// static method--> you have not to define the object, it is possible to
	// define it in the class

	public void addContact(Contact c) {
		if (!this.items.contains(c))
			this.items.add(c);
	}

	// controls whether distinct contact elements exist
	// control of duplicates

	public void removeContact(Contact c) {
		this.items.remove(c);
	}

	// delete contacts

	public int numOfContacts() {
		return this.items.size();
	}

	public void print() {
		AddressBook.printContacts(this.items);
	}

	// method

	public void exportContactsToFile(String filePath) {
		try {
			FileWriter writer = new FileWriter(filePath);

			writer.append("Vorname;Nachname;Adresse;eMail;Telefonnummer;Geburtsdatum;Firmenbezeichnung;FaxNummer;Firmen-WebSite\n");

			for (AddressBookItem a : this.items) {
				writer.append(a.toCsv());
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
		//Collections.sort(this.items, new ContactFirstnameComparator());
		//TODO: problem, cause ContactGroup has no firstname to be sorted by; to be discussed 
		this.print();
	}

	// sort after firstname

	public void printSortedBySurname() {
		//Collections.sort(this.items, new ContactSurnameComparator());
		//TODO: problem, cause ContactGroup has no surname to be sorted by; to be discussed
		this.print();
	}
}

// sort after surname