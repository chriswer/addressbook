package informatik2.hue5.addressbook;

public class BusinessContact extends Contact {
	// extends from class_contact

	private String companyName = "";
	private String fax = "";
	private String homepage = "";

	// member variables
	// visibility of the class (private --> can only be used within this class)

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getFax() {
		return this.fax;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getHomepage() {
		return this.homepage;
	}

	// getter and setter methods
	// controls from outside (interface) whether specific criteria are fulfilled

	public BusinessContact(String firstName, String surName, String address,
			String emailAddress, String phoneNumber, String companyName,
			String fax, String homepage) {
		super(firstName, surName, address, emailAddress, phoneNumber);
		
		// reference to parent class --> keyword super
		this.companyName = companyName;
		this.fax = fax;
		this.homepage = homepage;
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
		BusinessContact other = (BusinessContact) obj;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (homepage == null) {
			if (other.homepage != null)
				return false;
		} else if (!homepage.equals(other.homepage))
			return false;
		return true;
	}

	// override
	// equals --> compare whether there exist duplicates
	// compare as long as the answer is true otherwise it stops and sets the
	// answer false

	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result
				+ ((homepage == null) ? 0 : homepage.hashCode());
		return result;
	}

	// hashcode --> mathematics shortcut for an object
	// hashcode --> identifies the object (numerical figure)

	public void print() {
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

	public String toCsv() {
		StringBuilder result = new StringBuilder();
		String separator = ";";

		result.append(super.toCsv());

		result.append(this.getCompanyName());
		result.append(separator);
		result.append(this.getFax());
		result.append(separator);
		result.append(this.getHomepage());

		return result.toString();
	}

	public void equals() {
		
	}

}
//stringbuilder--> creates a new object that contains the empty sequence 
//of characters and space for (initially) offers up to 16 characters 	
//instead of: public void print() {
//System.out.println(firstname + " " + lastname + " " + address + " "
//+ email + " " + phone + " " + birthdate);
//to Csv --> table processing program
//--> separator has not to be a comma