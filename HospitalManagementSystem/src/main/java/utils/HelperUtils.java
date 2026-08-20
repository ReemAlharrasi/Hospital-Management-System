package utils;

public class HelperUtils {
    private static int idCounter = 1000;

    public static String generateId(String prefix) {
        idCounter = idCounter + 1;
        return prefix + idCounter;
    }

    public static boolean isEmpty(String str){
        return (str==null || str.trim().length()==0);
    }

    public static boolean isEmpty(Object[] items,int count){
        return (items==null || count ==0);
    }

    public static boolean isValidText(String txt){
        return !isEmpty(txt);
    }

    public static boolean isValidText(String txt,int minLength){
        return !isEmpty(txt) && txt.trim().length()>=minLength;
    }

    public static boolean isValidText(String txt,int minLength, int maxLength){
        return !isEmpty(txt) && txt.trim().length()>=minLength && txt.trim().length()<=maxLength;
    }
}
