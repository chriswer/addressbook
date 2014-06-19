package informatik2.hue5.addressbook;

import java.lang.StringBuilder;
import informatik2.hue5.addressbook.AddressBookItem;

//Collection Framework

public abstract class Contact extends AddressBookItem {

	private String firstname = "";
	private String surname = "";
	private String address = "";
	private String eMail = "";
	private String phone = "";

	// member variables
	// visibility of the class (private --> can only be used within this class)
	// abstract class --> cannot be defined, only extend

	public void setFirstname(String firstName) {
		this.firstname = firstName;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setSurname(String surName) {
		this.surname = surName;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return this.address;
	}

	public void setEMail(String emailAddress) {
		this.eMail = emailAddress;
	}

	public String getEMail() {
		return this.eMail;
	}

	public void setPhone(String phoneNumber) {
		this.phone = phoneNumber;
	}

	public String getPhone() {
		return this.phone;
	}

	// getter and setter methods
	// controls from outside (interface) whether specific criteria are fulfilled

	public Contact(String firstName, String surName) {
		this(firstName, surName, "", "", "");
	}

	public Contact(String firstName, String surName, String address,
			String emailAddress, String phoneNumber) {
		this.firstname = firstName;
		this.surname = surName;
		this.address = address;
		this.eMail = emailAddress;
		this.phone = phoneNumber;
	}

	// constructor--> defines an object
	// name of the constructor = name of the class

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((eMail == null) ? 0 : eMail.hashCode());
		result = prime * result
				+ ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	// override
	// hashcode --> mathematics shortcut for an object
	// hashcode --> identifies the object (numerical figure)

	public abstract void equals();

	// override
	// equals --> compare whether there exist duplicates
	// compare as long as the answer is true otherwise it stops and sets the
	// answer false

	// Alternative:
	// return new EqualsBuilder().
	// if deriving: appendSuper(super.equals(obj)).
	// append(this.getFirstname(), c.getFirstname()).
	// append(this.getSurname(), c.getSurname())....
	// isEquals();

	public void print() {
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

	// stringbuilder--> creates a new object that contains the empty sequence 
	// of characters and space for (initially) offers up to 16 characters 	
	// instead of: public void print() {
	// System.out.println(firstname + " " + lastname + " " + address + " "
	// + email + " " + phone + " " + birthdate);

	public String toCsv() {
		StringBuilder result = new StringBuilder();
		String separator = ";";

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

//to Csv --> table processing program
//--> separator has not to be a comma
