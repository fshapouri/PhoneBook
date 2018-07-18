package model;

import java.sql.*;
import java.util.Vector;


public class ContactDAO {
    private static String dbURL = "jdbc:derby://localhost:1527/c:/myDB;create=true";
    private static Connection cn=null;
    private static Statement st=null;

    private static void open() throws Exception{
        Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        cn=DriverManager.getConnection(dbURL);
        st=cn.createStatement();
    }

    public static void insertContact(Contact contact){
        try {
            open();
            st.executeUpdate("INSERT INTO CONTACT VALUES ("+ contact.getName() + ",'" + contact.getLastName() + "','" + contact.getContactId() +"')");
            close();
        }catch (Exception sqlExcept) {

            if (sqlExcept.getMessage().equals("Table/View 'CONTACT' does not exist.")) {
                try {
                    st.executeUpdate("CREATE TABLE CONTACT (contactId int , name VARCHAR (255) , lastName VARCHAR(255))");
                    insertContact(contact);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else {
                sqlExcept.printStackTrace();
            }
        }
    }
    public static void removeContact(Contact contact) throws Exception{
        open();
        st.executeUpdate("DELETE contact WHERE IDENTITY =" +contact.getContactId());
        close();
    }

    public static void updateContact(Contact contact)throws Exception{
        open();
        st.executeUpdate("UPDATE contact SET NAME =" +contact.getName()+ " WHERE IDENTITY=" +contact.getContactId());
        st.executeUpdate("UPDATE contact SET NAME =" +contact.getLastName()+ " WHERE IDENTITY=" +contact.getContactId());
        close();
    }

    public static Contact[] getAllContacts() throws Exception{
        Vector v=new Vector();
        open();
        ResultSet result=st.executeQuery("SELECT * FROM contact");
        while (result.next()){
            int id=result.getInt("contactId");
            String name=result.getString("contactName");
            String lastname=result.getString("lastName");

            Contact contact=new Contact(id,name,lastname);
            v.addElement(contact);
        }
     return (Contact[]) v.toArray(new Contact[0]);
    }
     private static void close() throws SQLException{
        st.close();
        cn.close();
     }
}
