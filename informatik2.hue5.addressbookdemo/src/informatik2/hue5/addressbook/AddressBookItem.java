package informatik2.hue5.addressbook;

public abstract class AddressBookItem {

	public AddressBookItem () {}
	
	public abstract void print();
	public abstract String toCsv();
}