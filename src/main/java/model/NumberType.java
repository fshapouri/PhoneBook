package model;

public enum  NumberType{
    home,
    mobile,
    work,
    fax,
    other;

 public static NumberType find(int ordinal){
     for (NumberType numberType:NumberType.values()){
         if (numberType.ordinal()==ordinal)
             return numberType;
       }return null;
    }
}