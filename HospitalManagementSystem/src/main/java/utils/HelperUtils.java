package utils;

public class HelperUtils {
    private static int idCounter = 1000;

    public static String generateId(String prefix) {
        idCounter = idCounter + 1;
        return prefix + idCounter;
    }
}
