package informatik2.hue4.addressbookdemo;
//import org.apache.commons.lang.builder.EqualsBuilder;


public class BusinessContact extends Contact
{
	
	// Member-Variablen
	private String companyName = "";
	private String fax = "";
	private String homepage = "";
	
	
	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}

    public String getCompanyName()
    {
       return this.companyName;
    }
    
    public void setFax(String fax)
	{
		this.fax = fax;
	}

    public String getFax()
    {
       return this.fax;
    }
    
    public void setHomepage(String homepage)
	{
		this.homepage = homepage;
	}

    public String getHomepage()
    {
       return this.homepage;
    }
	
    
	
	//---------------------------------------------------------------------------------------------------
    // Konstruktoren
    //---------------------------------------------------------------------------------------------------
    public BusinessContact (String firstName, String surName, String address, String emailAddress, String phoneNumber, String companyName, String fax, String homepage)
	{
    	super(firstName,surName,address,emailAddress,phoneNumber);
    	
		this.companyName = companyName;
		this.fax = fax;
		this.homepage = homepage;
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
    	if(!(obj instanceof BusinessContact))
    		return false;
    	
    	BusinessContact bc = (BusinessContact) obj;
    	
    	if(!super.equals(bc))
    		return false; 
    	
    	return (this.getCompanyName() == bc.getCompanyName() &&
    			this.getFax() == bc.getFax() &&
    					this.getHomepage() == bc.getHomepage());
    	
    	
/* 	     return new EqualsBuilder().
         appendSuper(super.equals(bc)).
         append(this.getCompanyName(), bc.getCompanyName()).
         isEquals();
 */	 
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
		
		sb.append("BusinessContact [Firstname: ");
		sb.append(this.getFirstname());
		sb.append(", Surname: ");
		sb.append(this.getSurname());
		sb.append(", Address: ");
		sb.append(this.getAddress());
		sb.append(", EMail: ");
		sb.append(this.getEMail());
		sb.append(", Phone: ");
		sb.append(this.getPhone());
		
		sb.append(", CompanyName: ");
		sb.append(this.getCompanyName());
		sb.append(", Fax: ");
		sb.append(this.getFax());
		sb.append(", Homepage: ");
		sb.append(this.getHomepage());
		
		sb.append("]");
		
		System.out.println(sb.toString());
    }
}
