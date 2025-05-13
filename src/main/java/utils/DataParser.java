package utils;

public class DataParser {
    public static double parseDouble(String value) {
        if (value == null || value.trim().isEmpty()) {
            return 0.0;
        }
        try {
            return Double.parseDouble(value.replace("\"", "").replace(",", ""));
        } catch (NumberFormatException e) {
            return 0.0; // Default to 0.0 if parsing fails
        }
    }
}
