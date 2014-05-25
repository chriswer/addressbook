package informatik2.hue4.addressbookdemo;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


public class PrivateContact extends Contact
{
	
	// Member-Variablen
	private GregorianCalendar birthdate = null;
	
	
	public void setBirthdate(GregorianCalendar birthdate)
	{
		this.birthdate = birthdate;
	}

    public GregorianCalendar getBirthdate()
    {
       return this.birthdate;
    }
    
   
    
    
	
	//---------------------------------------------------------------------------------------------------
    // Konstruktoren
    //---------------------------------------------------------------------------------------------------
    public PrivateContact (String firstName, String surName, String address, String emailAddress, String phoneNumber, GregorianCalendar birthdate)
	{
    	super(firstName,surName,address,emailAddress,phoneNumber);
		this.birthdate= birthdate;
	}


   
	
	
	//---------------------------------------------------------------------------------------------------
    // Methoden
    //---------------------------------------------------------------------------------------------------
	
    @Override
    public boolean equals(Object obj)
    {
    	if (obj == null)
            return false;
        if (obj == this)
            return true;
    	if(!(obj instanceof PrivateContact))
    		return false;
    	
    	PrivateContact pc = (PrivateContact) obj;
    	
    	if(!super.equals(pc))
    		return false; 
    	
    	return (this.getBirthdate() == pc.getBirthdate());
	}

    
    @Override
    public int hashCode ()
    {
		return 0;
	}
    
    
    @Override 
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
		
		sb.append(", Birthdate: ");
		sb.append(dateFormat.format(this.getBirthdate().getTime()));
		
		sb.append("]");
		
		System.out.println(sb.toString());
    }
}
