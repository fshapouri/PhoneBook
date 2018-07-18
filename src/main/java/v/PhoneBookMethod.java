package v;

import model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBookMethod {

    Scanner input = new Scanner(System.in);

    //    private List<model.Contact> contacts = new ArrayList<>();
    private List<PhoneNumber> phoneNumbers = new ArrayList();

    Contact contact = new Contact();
    PhoneNumber phoneNumber = new PhoneNumber();
    PhoneBook phoneBook = new PhoneBook();

    public void addContact(PhoneBook phoneBook) {
        // try {
        System.out.println("How many contact do you want add to list?");
        int count = input.nextInt();

        for (int i = 1; i <= count; i++) {
            System.out.println("contact" + i + ":");
            System.out.print(" Enter name please :");
            // contact.setName(input.next());
            String name = input.next();

            System.out.print(" Enter family please :");
            //  contact.setLastName(input.next());
            String family = input.next();

            List<PhoneNumber> phoneNumbers = addNumber();
            phoneBook.getContacts().add(new Contact());

           System.out.println("***************************");
        }

    }

    public List<PhoneNumber> addNumber() {

        try {
            System.out.println("How many Phonenumber do you want add to list?");
            int countNumber = input.nextInt();

            for (int j = 1; j <= countNumber; j++) {
                System.out.println("number" + j + ":");

                System.out.print(" Enter number please :");
//                phoneNumber.setNumber(input.next());
                String number = input.next();

                System.out.println("please enter number type of your number :\n1)HOME  2)MOBILE  3)WORK  4)fax 5)Other");
                int type = input.nextInt();
                NumberType numberType = null;
                switch (type) {
                    case 1:
                        numberType = NumberType.home;
                        break;
                    case 2:
                        numberType = NumberType.mobile;
                        break;
                    case 3:
                        numberType = NumberType.fax;
                        break;
                    case 4:
                        numberType = NumberType.work;
                        break;
                    case 5:
                        numberType = NumberType.other;
                        break;
                    default:
                        System.out.println("please enter valid type!!");
                }
                phoneNumber.getNumberType();
                phoneNumbers.add(new PhoneNumber());
            }

        } catch (Exception e) {
            System.out.println("\n");
            addNumber();
        }
        return phoneNumbers;
    }

    public void removeContact() {
        String name;
        String lastName;

        System.out.println(" Enter name please :");
        name = input.next();
        System.out.println(" Enter family please :");
        lastName = input.next();

        List<Contact> contacts = phoneBook.getContacts();
        for (Contact contact : contacts) {
            if (name.equals(contact.getName()) && lastName.equals(contact.getLastName()))
                System.out.println("Are you sure you want to delete?");
                contacts.remove(contact);
        }
    }

    public void searchContact() {
        String searchName;
        String searchLastname;
        boolean flag = true;

        while (flag) {
            System.out.print("Enter name for search please :");
            searchName = input.next();
            System.out.print(" Enter family for search please :");
            searchLastname = input.next();

            List<Contact> contacts = phoneBook.getContacts();

            for (Contact contact : contacts) {
                if (searchName.equalsIgnoreCase(contact.getName()) && searchLastname.equalsIgnoreCase(contact.getLastName())){
                    contact.show();
                    flag = false;}
               else {
                    System.out.print("Do you make a search?(yes/no)");
                    String check = input.next();
                    if (check.equalsIgnoreCase("yes")) flag = true;
                    else flag = false;
                }
            }
        }
    }

    public void editContact() {
        String editName;
        String editLastname;

        System.out.print("Enter name please");
        editName = input.next();
        System.out.print(" Enter family please :");
        editLastname = input.next();

        List<Contact> contacts = phoneBook.getContacts();

        for (Contact contact : contacts) {
            if (editName.equals(contact.getName()) && editLastname.equals(contact.getLastName())) {
                List<PhoneNumber> phoneNumbers = addNumber();
            }
                 contact.setPhoneNumbers();
        }
        System.out.println("Your request has been successfully completed");
    }

    public void display() {
        List<Contact> contacts = phoneBook.getContacts();
        for (Contact contact : contacts) {
            System.out.println("fullname:" + contact.getName() + " " + contact.getLastName());
            for (PhoneNumber phoneNumber : phoneNumbers) {
                System.out.println("phone Number:" + phoneNumber.getNumber() + "\t" +
                        "Type number:" + phoneNumber.getNumberType().name());
            }
            System.out.println("\t*****\t*****\t*****");
        }

    }
}








