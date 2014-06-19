package informatik2.hue5.addressbook;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
// collection framework
// calendar

public class PrivateContact extends Contact
{
	
	private GregorianCalendar birthdate = null;
	
	
	public void setBirthdate(GregorianCalendar birthdate)
	{
		this.birthdate = birthdate;
	}

    public GregorianCalendar getBirthdate()
    {
       return this.birthdate;
    }
     
	// member variables
	// visibility of the class (private --> can only be used within this class)
	

    public PrivateContact (String firstName, String surName, String address, String emailAddress, String phoneNumber, GregorianCalendar birthdate)
	{
    	super(firstName,surName,address,emailAddress,phoneNumber);
		this.birthdate= birthdate;
	}
    
    public PrivateContact (String firstName, String surName)
	{
    	super(firstName,surName);
	}

    public PrivateContact (String firstName, String surName, GregorianCalendar birthdate)
  	{
      	super(firstName,surName);
    	this.birthdate= birthdate;
  	}

	// constructor--> defines an object
	// name of the constructor = name of the class


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrivateContact other = (PrivateContact) obj;
		if (birthdate == null) {
			if (other.birthdate != null)
				return false;
		} else if (!birthdate.equals(other.birthdate))
			return false;
		return true;
	}

	// override
	// cast --> type conversion 
	// !--> not operator ; takes the inverse from the boolean
	

	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((birthdate == null) ? 0 : birthdate.hashCode());
		return result;
	}
    
    // override 
	// hashcode --> mathematics shortcut for an object
	// hashcode --> identifies the object (numerical figure)
	
    public void print ()
    {
		StringBuilder sb = new StringBuilder();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		
		sb.append("PrivateContact [Firstname: ");
		sb.append(this.getFirstname());
		sb.append(", Surname: ");
		sb.append(this.getSurname());
		sb.append(", Address: ");
		sb.append(this.getAddress());
		sb.append(", EMail: ");
		sb.append(this.getEMail());
		sb.append(", Phone: ");
		sb.append(this.getPhone());
		
		if(this.getBirthdate() != null) {
			sb.append(", Birthdate: ");
			sb.append(dateFormat.format(this.getBirthdate().getTime()));
		}
		
		sb.append("]");
		
		System.out.println(sb.toString());
    }

	public void equals() {
		
	}

}
// stringbuilder--> creates a new object that contains the empty sequence 
// of characters and space for (initially) offers up to 16 characters 	
// instead of: public void print() {
// System.out.println(firstname + " " + lastname + " " + address + " "
// + email + " " + phone + " " + birthdate);
