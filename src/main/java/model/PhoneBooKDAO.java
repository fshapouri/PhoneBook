package model;

import  java.sql.*;
import java.util.Vector;


public class PhoneBooKDAO {
    private static String dbURL = "jdbc:derby://localhost:1527/c:/myDB;create=true";
    private static Connection cn=null;
    private static Statement st=null;

    //opet db connection
     private static void open() throws Exception{
         Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
         cn= DriverManager.getConnection(dbURL);
         st=cn.createStatement();
     }
     //insert a new phonebook to db.
    public static void insertPhonebook(PhoneBook phoneBook) {
        try {
            open();
            st.executeUpdate("INSERT INTO phoneBook VALUES (" + phoneBook.getPhoneBookId() + ",'" + phoneBook.getPhoneBookName() + "')");
            close();
        } catch (Exception sqlExcept) {

            if (sqlExcept.getMessage().equals("Table/PhoneBookMethod 'PHONEBOOK' does not exist")) {
                try {
                    st.executeUpdate("CREATE TABLE  PHONEBOOK(phoneBookId int , phoneBookName VARCHAR (255))");
                    insertPhonebook(phoneBook);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else {
                sqlExcept.printStackTrace();
            }
        }
    }

    public static void removePhonebook(PhoneBook phoneBook) throws Exception{
         open();
         st.executeUpdate("DELETE phoneBook WHERE IDENTITY = "+phoneBook.getPhoneBookId());
         close();
    }

    //update an existing phonebook
    public static void updatePhonebook(PhoneBook phoneBook) throws Exception{
         open();
         st.executeUpdate("UPDATE phoneBook SET NAME ="+phoneBook.getPhoneBookName()+ " WHERE IDENTITY=" +phoneBook.getPhoneBookId());
         close();
    }

    //retrive all phonebooks from db
    public static PhoneBook[] selectPhonebooks() throws Exception{
        Vector v=new Vector();
        open();
        ResultSet result=st.executeQuery("SELECT * FROM phoneBook");
        while (result.next()){
            int id= result.getInt("phoneBookId");
            String phoneBookName=result.getString("phoneBookName");

            PhoneBook phoneBook=new PhoneBook();
            v.addElement(phoneBook);
        }
        close();
        return (PhoneBook[]) v.toArray(new PhoneBook[0]);
    }
//
    private static void close() throws SQLException{
         st.close();
         cn.close();

    }



}
