package model;

import java.sql.*;
import java.util.Vector;

public class PhoneNumberDAO {

    private static String dbURL = "jdbc:derby://localhost:1527/c:/myDB;create=true";
    private static Connection cn=null;
    private static Statement st=null;

    private static void open() throws Exception{
        Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        cn=DriverManager.getConnection(dbURL);
        st=cn.createStatement();
    }

    public static void insertPhoneNumber(PhoneNumber phoneNumber){
        try {
            open();
            st.executeUpdate("INSERT INTO phoneNumber VALUES ("+phoneNumber.getPhoneNumberId()+ ",'"+phoneNumber.getNumber()+"','"+phoneNumber.getNumberType()+"')");
            close();
        }catch (Exception sqlExcept) {

            if (sqlExcept.getMessage().equals("Table/View 'PHONENUMBER' does not exist.")) {
                try {
                    st.executeUpdate("CREATE TABLE PHONENUMBER(phoneNumberId int , number int, numberType int )");
                    insertPhoneNumber(phoneNumber);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }else {
                sqlExcept.printStackTrace();
            }
        }

    }

    public static void removePhoneNumber(PhoneNumber phoneNumber)throws Exception{
        open();
        st.executeUpdate("DELETE phoneNumber WHERE IDENTITY" + phoneNumber.getPhoneNumberId());
        close();
    }

    public static void updatePhoneNumber(PhoneNumber phoneNumber) throws Exception{
        open();
        st.executeUpdate("UPDATE phoneNumber SET NUMBER=" + phoneNumber.getNumber()+ " WHERE IDENTITY=" +phoneNumber.getPhoneNumberId() );
        st.executeUpdate("UPDATE phoneNumber SET NUMBER TYPE=" +phoneNumber.getNumberType()+" WHERE IDENTITY " +phoneNumber.getPhoneNumberId());
        close();
    }

    public static PhoneNumber[] getAllPhoneNumbers() throws Exception{
        Vector v=new Vector();
        ResultSet result=st.executeQuery("SELECT * FROM PhoneNumber");
        while (result.next()){
            int id= result.getInt("phoneNumberId");
            int number=result.getInt("number");
            int type=result.getInt("numberType");
            PhoneNumber phoneNumber=new PhoneNumber();
            v.addElement(phoneNumber);
        }
        return (PhoneNumber[]) v.toArray(new PhoneNumber[0]);
    }

    private static void close() throws SQLException{
        st.close();
        cn.close();
    }

}
