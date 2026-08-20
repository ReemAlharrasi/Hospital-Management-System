package utils;

public class HelperUtils {
    private static int idCount = 123456;

    //id helpers
    public static String generateId(String prefix) {
        idCount = idCount + 1;
        return prefix + idCount;
    }
    public static String generateId() {
        idCount = idCount + 1;
        return "ID" + idCount;
    }

    //text helpers
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

    //number helpers
    //positive
    public static boolean isPositive(int num){return num>=0;}

    public static boolean isPositive(double num){return num>=0;}

    //check range
    public static boolean inRange(int value, int min, int max) {
        return value >= min && value <= max;
    }

    public static boolean inRange(double value, double min, double max) {
        return value >= min && value <= max;
    }

}
