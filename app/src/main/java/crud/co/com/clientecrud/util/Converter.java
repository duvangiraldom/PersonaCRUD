package crud.co.com.clientecrud.util;

public class Converter {

    public static Integer StringToInteger(String value){
        return "".equals(value)?0: Integer.parseInt(value);
    }
}


