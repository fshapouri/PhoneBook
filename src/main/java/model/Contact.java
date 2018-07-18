package model;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    private int contactId;
    private String name;
    private String lastName;
    private List<PhoneNumber> phoneNumbers=new ArrayList();

    public Contact(int contactId, String name, String lastName){
        this.contactId = contactId;
        this.name=name;
        this.lastName=lastName;
    }

    public Contact (){

    }

    public void show(){
        System.out.println("Fullname:" + name + " " +lastName );
        for (PhoneNumber phoneNumber:phoneNumbers) {
            System.out.println("phone Number:" +phoneNumber.getNumber()+ "\t" +
                    "Type number:" +phoneNumber.getNumberType().name());

        }
    }


    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public List<PhoneNumber> getPhoneNumbers() {return phoneNumbers;}

    public void setPhoneNumbers() {this.phoneNumbers = phoneNumbers;}


    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }
}
