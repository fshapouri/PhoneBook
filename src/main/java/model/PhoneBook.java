package model;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private int phoneBookId;
    private String phoneBookName;
    private List<Contact> contacts=new ArrayList();

//    public model.PhoneBook (int phoneBookId,String phoneBookName){
//        this.phoneBookId=phoneBookId;
//        this.phoneBookName=phoneBookName;
//    }
    public PhoneBook (){

    }


    public List<Contact> getContacts() {return this.contacts;}

    public void setContacts(List<Contact> contacts) {this.contacts = contacts;}

    public String getPhoneBookName() {return phoneBookName;}

    public void setPhoneBookName(String phoneBookName) {this.phoneBookName = phoneBookName;}

    public int getPhoneBookId() {return phoneBookId;}

    public void setPhoneBookId(int phoneBookId) {this.phoneBookId = phoneBookId;}
}
