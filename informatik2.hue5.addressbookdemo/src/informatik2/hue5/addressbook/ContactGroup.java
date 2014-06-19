package informatik2.hue5.addressbook;

import informatik2.hue5.addressbook.Contact;

import java.util.LinkedList;

public class ContactGroup extends Contact {

		private String title;
		private String description;
		private LinkedList<Integer> members;
		
		
		public void settitle(String title) {
			this.title = title;
		}

		public String gettitle() {
			return this.title;
		}

		public void setdescription(String description) {
			this.description = description;
		}

		public String getdescription() {
			return this.description;
		}

		
		public ContactGroup(String firstName, String surName, String address,
				String emailAddress, String phoneNumber, String title,
				String description) {
			super(firstName, surName, address, emailAddress, phoneNumber);
			
			// reference to parent class --> keyword super
			
			this.title = title;
			this.description = description;
			this.members = new LinkedList<Integer>();
			
			// constructor
		}
		
		
		// checks if there are members referenced, which are already deleted contacts
		public void checkIfReferencedMembersAreStoredContacts(LinkedList<Contact> contacts){
			// check if some members no longer exists
			// we don't wan't to operate on the original
			for(final Integer hash: new LinkedList<Integer>(this.members)){
				// build a dummy object with overridden hashcode and 
				// equals function to serve our need of finding the 
				// object we're looking for.
				if(!contacts.contains(new Object(){
					public int c() {
						return c();
					}
					public boolean equals(Object obj){
						return obj.c() == c;
					}
					// if it doesnt contain the specific hash, 
					// we have a member without any contact in the addressbook 
				})) this.members.remove(c);
			}
		}
		
		// returns a string representing the group object with the contact information
		public String getContactGroup(LinkedList<Contact> contacts){
			String retval="";
			if(this.members.size()>0){
				retval="In group '"+this.title+"' are "+this.members.size()+" members\n"+
					   "with describtion: '"+this.description+"'\n";
				for(Contact c:contacts){
					for(Integer c: this.members){
						if(c()==c){
							retval+=c.getContact()+"\n";
						}
					}
				}
			}else{
				retval="In group '"+this.title+"' are 0 member\n"+
					   "with describtion: "+this.description;
			}
			return retval;
		}
		
		public void addMember(Integer Contact c)  {
			if (!this.addMember.contains(c))
				this.addMember(c);
			else throw new Exception("Adding failed, member: '"+c+"' of group: '"+this.title+"' already exists!");
		}
		
		public void addMember(Contact c) throws Exception {
			try {
				this.addMember (c);
			}
			catch (Exception e){
				throw new Exception("Delete failed, member '"+c.getSurname()+", "+c.getFirstname()+"' of group: '"+this.title+"' could not find!");
			}
		}

		// controls whether distinct contact elements exist
		// control of duplicates
		
		public void removeMember(Integer Contact c) throws Exception {
			if(!this.members.remove(c)){
				throw new Exception("Delete failed, member '"+c+"' of group: '"+this.title+"' coudl not find!");
			}
		}
		
		public void removeMember(Contact c) throws Exception {
			try {
				this.removeMember (c);
			}
			catch (Exception e){
				throw new Exception("Delete failed, member '"+c.getSurname()+", "+c.getFirstname()+"' of group: '"+this.title+"' could not find!");
			}
				
			}

		// checks if the given hashcode is a member of the group
		public boolean isMember(Integer c){
			return this.members.contains(c);
		}
		
		// same as above, but takes a Contact as parameter
		public boolean isMember(Contact c){
			return this.isMember(c);
		}
		
		// returns all members with an hashcode-interger-array
		public Integer[] getMembers(){
			return this.members.size()<1?new Integer[0]:this.members.toArray(new Integer[this.members.size()]);
		}
		
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result
					+ ((description == null) ? 0 : description.hashCode());
			result = prime * result
					+ ((members == null) ? 0 : members.hashCode());
			result = prime * result + ((title == null) ? 0 : title.hashCode());
			return result;
		}


		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ContactGroup other = (ContactGroup) obj;
			if (description == null) {
				if (other.description != null)
					return false;
			} else if (!description.equals(other.description))
				return false;
			if (members == null) {
				if (other.members != null)
					return false;
			} else if (!members.equals(other.members))
				return false;
			if (title == null) {
				if (other.title != null)
					return false;
			} else if (!title.equals(other.title))
				return false;
			return true;
		}

		public void equals() {
			
		}
		
	}


