package informatik2.hue3.addressbookdemo;

public class Contact
{
	
	// Member-Variablen
	private String firstName = "";
	private String lastName = "";
	private String address = "";
	private String email = "";
	private String telnum = "";
	private String birthDate = "";
	
	
	
	// Getter und Setter
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

    public String getFirstName()
    {
       return this.firstName;
    }
    
    public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

    public String getLastName()
    {
       return this.lastName;
    }
    
    public void setAddress(String address)
	{
		this.address = address;
	}

    public String getAddress()
    {
       return this.address;
    }
    
    public void setEmail(String emailAddress)
	{
		this.email = emailAddress;
	}

    public String getEmail()
    {
       return this.email;
    }
    
    public void setTelnum(String phoneNumber)
	{
		this.telnum = phoneNumber;
	}

    public String getTelnum()
    {
       return this.telnum;
    }
    
    public void setBirthDate(String birthDate)
	{
		this.birthDate = birthDate;
	}

    public String getBirthDate()
    {
       return this.birthDate;
    }
	
	
	
	//---------------------------------------------------------------------------------------------------
    // Konstruktoren
    //---------------------------------------------------------------------------------------------------
	public Contact (String firstName, String lastName)
	{
		this(firstName, lastName, "","","","");
	}
	
	
	
	public Contact (String firstName, String lastName, String address, String emailAddress, String phoneNumber, String birthDate)
	{
		this.firstName =  firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = emailAddress;
		this.telnum = phoneNumber;
		this.birthDate = birthDate;
	}
	
	
	
	//---------------------------------------------------------------------------------------------------
    // Methoden
    //---------------------------------------------------------------------------------------------------
	public void print ()
	{
		System.out.println("\n\nContact");
		System.out.println("----------------------------------------");
		System.out.println("Firstname: " + this.getFirstName());
		System.out.println("Lastname: " + this.getLastName());
		System.out.println("Address: " + this.getAddress());
		System.out.println("Email: " + this.getEmail());
		System.out.println("Phone number: " + this.getTelnum());
		System.out.println("Birthdate: " + this.getBirthDate());
		System.out.println("----------------------------------------\n");
		
	}
}
