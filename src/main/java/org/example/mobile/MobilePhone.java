package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts = new ArrayList<>();

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
        for(Contact c:myContacts){
            if(c.getName().equals(contact.getName())){
                return false;
            }
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        for(Contact c:myContacts){
            if(c.getName().equals(oldContact.getName())){
                c.setPhoneNumber(newContact.getPhoneNumber());
                return true;
            }
        }
        return false;
    }

    public boolean removeContact(Contact contact){
        for(Contact c:myContacts){
            if(c.getName().equals(contact.getName())){
                myContacts.remove(contact);
                return true;
            }
        }
        return false;
    }

    public int findContact(Contact contact){
        for(Contact c:myContacts){
            if(c.getName().equals(contact.getName())){
                return myContacts.indexOf(c);
            }
        }
        return -1;
    }

    public int findContact(String contact){
        for(Contact c:myContacts){
            if(c.getName().equals(contact)){
                return myContacts.indexOf(c);
            }
        }
        return -1;
    }

    public Contact queryContact(String contactName){
        for(Contact c:myContacts){
            if(c.getName().equals(contactName)){
                return c;
            }
        }
        return null;
    }
    public void printContact(){
        for(Contact c:myContacts){
            System.out.println(c.getName()+"->"+c.getPhoneNumber());
        }
    }

}
