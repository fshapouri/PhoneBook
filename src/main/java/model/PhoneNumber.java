package model;

public class PhoneNumber {
    private int phoneNumberId;
    private String number;
    private NumberType numberType;

    public PhoneNumber(){}

    public PhoneNumber(int phoneNumberId, String number, NumberType numberType){
        this.phoneNumberId = phoneNumberId;
        this.number=number;
        this.numberType=numberType;
    }

    public String getNumber() {return number;}

    public void setNumber(String number) {this.number = number;}

    public NumberType getNumberType() {return numberType;}

    public void setNumberType(NumberType numberType) {this.numberType = numberType;}


    public int getPhoneNumberId() {
        return phoneNumberId;
    }

    public void setPhoneNumberId(int phoneNumberId) {
        this.phoneNumberId = phoneNumberId;
    }
}
