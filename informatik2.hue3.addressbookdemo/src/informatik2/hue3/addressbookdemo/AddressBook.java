package informatik2.hue3.addressbookdemo;

import informatik2.hue3.addressbookdemo.Contact;


public class AddressBook
{
	//Member-Variablen
	private String title = "";
	private int maxSize = 0;
	private int size = 0;
	private Contact[] contacts = null;
	
	
	
	//Getter und Setter
	public void setTitle(String title)
	{
		this.title = title;
	}

    public String getTitle()
    {
       return this.title;
    }
    
    public void setMaxSize(int maxSize)
	{
		this.maxSize = maxSize;
	}

    public int getmaxize()
    {
       return this.maxSize;
    }
    
    
    
    //---------------------------------------------------------------------------------------------------
    // Konstruktor
    //---------------------------------------------------------------------------------------------------
	public AddressBook (String title, int maxSize) 
	{
		this.title = title;
		this.maxSize = maxSize;
		this.size = 0;
		this.contacts = new Contact[this.maxSize];
	}
	
	
	
	//---------------------------------------------------------------------------------------------------
    // Statische Methode
    //---------------------------------------------------------------------------------------------------
	public static void printContacts (Contact[] contacts) 
	{
		Contact c = null;
		for (int i=0; i < contacts.length; i++)
		{
			c = contacts[i];
					
			if(c != null)
			{
				c.print();
			}
		}
	}
		
	
	
	//---------------------------------------------------------------------------------------------------
    // Methoden
    //---------------------------------------------------------------------------------------------------
	public void addContact (Contact c) 
	{
		if(this.size < this.maxSize)
		{
			//todo: check here for duplicates before adding a contact
			
			this.contacts[this.size] = c;
			this.size++;
		}
	}
	
	
	public void removeContact (Contact c) 
	{
		/*todo: loop through contacts and find the given contact c
			if found: remove c from the array and decrement size
			if not found: skip */
	}
	
	
	public int numOfContacts () 
	{
		return this.size;
	}

	
	public void print () 
	{
		AddressBook.printContacts(this.contacts);
	}
	
	
	public Contact lookupByEmail (String email) 
	{
		Contact result = null;
		Contact c = null;
		
		for (int i=0; i < contacts.length; i++)
		{
			c = contacts[i];
			
			if(c != null && c.getEmail() == email)
			{
				result = c;
				break;
			}
		}
		
		return result;
	}
		
	
	public Contact lookupByName (String firstName, String lastName) 
	{
		Contact result = null;
		Contact c = null;
		
		for (int i=0; i < contacts.length; i++)
		{
			c = contacts[i];
			
			if(c != null && c.getFirstName() == firstName && c.getLastName() == lastName)
			{
				result = c;
				break;
			}
		}
		
		return result;
	}
}
