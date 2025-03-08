package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts;

    public MobilePhone(String myNumber, List<Contact> contacts) {
        this.myNumber = myNumber;
        this.myContacts=contacts;
    }

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact){
        if( contact==null || contact.getName()==null || contact.getPhoneNumber()==null){
            return false;
        }
        if(findContact(contact)>0){
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        if(findContact(oldContact)>0){
            myContacts.set(findContact(oldContact),newContact);
            return true;
        }
        return false;
    }

    public boolean removeContact(Contact contact){
        if(contact!=null && findContact(contact)>0){
            myContacts.remove(contact);
            return true;
        }
        return false;
    }

    public int findContact(Contact contact){
        return this.myContacts.indexOf(contact);
    }

    public int findContact(String contact){
        for(Contact c:myContacts){
            if(c.getName().equalsIgnoreCase(contact)){
                return myContacts.indexOf(c);
            }
        }
        return -1;
    }

    public Contact queryContact(String contactName){
        if(findContact(contactName)>0){
            return myContacts.get(findContact(contactName));

        }
        return null;
    }
    public void printContacts(){
        for(Contact c:myContacts){
            System.out.println(c.getName()+"->"+c.getPhoneNumber());
        }
    }

}
