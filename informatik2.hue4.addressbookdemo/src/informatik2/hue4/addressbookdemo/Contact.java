package informatik2.hue4.addressbookdemo;

import java.lang.StringBuilder;


public abstract class Contact
{
	
	// Member-Variablen
	private String firstname = "";
	private String surname = "";
	private String address = "";
	private String eMail = "";
	private String phone = "";
	
	
	
	// Getter und Setter
	public void setFirstname(String firstName)
	{
		this.firstname = firstName;
	}

    public String getFirstname()
    {
       return this.firstname;
    }
    
    public void setSurname(String surName)
	{
		this.surname = surName;
	}

    public String getSurname()
    {
       return this.surname;
    }
    
    public void setAddress(String address)
	{
		this.address = address;
	}

    public String getAddress()
    {
       return this.address;
    }
    
    public void setEMail(String emailAddress)
	{
		this.eMail = emailAddress;
	}

    public String getEMail()
    {
       return this.eMail;
    }
    
    public void setPhone(String phoneNumber)
	{
		this.phone = phoneNumber;
	}

    public String getPhone()
    {
       return this.phone;
    }
   
    
	
	
	//---------------------------------------------------------------------------------------------------
    // Konstruktoren
    //---------------------------------------------------------------------------------------------------
	public Contact (String firstName, String surName)
	{
		this(firstName, surName, "","","");
	}
	
	
	
	public Contact (String firstName, String surName, String address, String emailAddress, String phoneNumber)
	{
		this.firstname =  firstName;
		this.surname = surName;
		this.address = address;
		this.eMail = emailAddress;
		this.phone = phoneNumber;
	}
	
	
	
	//---------------------------------------------------------------------------------------------------
    // Methoden
    //---------------------------------------------------------------------------------------------------
	
	@Override
    public int hashCode()
    {
		return 0;
    }

	
	@Override
    public boolean equals(Object obj)
    {
		if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (!(obj instanceof Contact))
            return false;
    	
    	Contact c = (Contact) obj;
    	
    	return (this.getFirstname() == c.getFirstname() &&
    			this.getSurname() == c.getSurname() &&
    					this.getAddress() == c.getAddress() &&
    							this.getEMail() == c.getEMail() &&
    									this.getPhone() == c.getPhone());
    	
    	/*Alternative:
    	   return new EqualsBuilder().
            // if deriving: appendSuper(super.equals(obj)).
            append(this.getFirstname(), c.getFirstname()).
            append(this.getSurname(), c.getSurname()).
            ...
            isEquals();
    	 */
	}
	
	
	public void print ()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Contact [Firstname: ");
		sb.append(this.getFirstname());
		sb.append(", Surname:");
		sb.append(this.getSurname());
		sb.append(", Address: ");
		sb.append(this.getAddress());
		sb.append(", EMail: ");
		sb.append(this.getEMail());
		sb.append(", Phone: ");
		sb.append(this.getPhone());
		sb.append("]");
		
		System.out.println(sb.toString());
	}
	
	
	public String toCsv()
	{
		return this.toCsv(";"); 
	}
	
	
	public String toCsv(String separator)
	{
		StringBuilder result = new StringBuilder();
		
		result.append(this.getFirstname());
		result.append(separator);
		result.append(this.getSurname());
		result.append(separator);
		result.append(this.getAddress());
		result.append(separator);
		result.append(this.getEMail());
		result.append(separator);
		result.append(this.getPhone());
		
		return result.toString();
	}
}
