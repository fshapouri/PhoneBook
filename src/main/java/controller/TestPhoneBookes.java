package controller;

import model.*;
import v.*;
import java.util.Scanner;

public class TestPhoneBookes {

    public static void main(String[] args) throws Exception {

        System.out.println("please Enter name of your phone book");
        Scanner input = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        v.PhoneBookMethod phoneBookMethod=new PhoneBookMethod();
        phoneBook.setPhoneBookName(input.next());

        boolean exit = true;
        while (exit) {
            System.out.println("please enter a number :\n"
                    + "1)addContact " +
                    "2)removeContact" +
                    " 3)searchContact " +
                    "4)editContact" +
                    " 5)displayContact" +
                    " 6)Exit");
            int x = input.nextInt();
            switch (x) {
                case 1:
                    phoneBookMethod.addContact(phoneBook);
                    break;
                case 2:
                    phoneBookMethod.removeContact();
                    break;
                case 3:
                    phoneBookMethod.searchContact();
                    break;
                case 4:
                    phoneBookMethod.editContact();
                    break;
                case 5:
                    phoneBookMethod.display();
                    break;
                case 6:
                    exit = false;
                    System.out.println("DONE");
                default:
                    System.out.println("Your number dont valid try again please");
            }
        }
//        PhoneBook phone= new PhoneBook();
//        PhoneBooKDAO.insertPhonebook(phone);
         Contact contact=new model.Contact();
         ContactDAO.insertContact(contact);
//         PhoneNumber phoneNumber=new PhoneNumber();
//         PhoneNumberDAO.insertPhoneNumber(phoneNumber);
    }

}






