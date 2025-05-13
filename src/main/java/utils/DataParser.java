package utils;

// Use a data parsing utility class to handle string to double conversion
public class DataParser {

    // This method parses a string to a double value.
    public static double parseDouble(String value) {

        // This will check if the value is empty, it will return a default value of 0
        if (value == null || value.trim().isEmpty()) {
            return 0.0;
        }

        /* else the value are not zero, it proceed parsing or
        modify the data from the csv to the program.
         */
        try {
            return Double.parseDouble(value.replace("\"", "").replace(",", ""));
        } catch (NumberFormatException e) {
            return 0.0; // Default to 0.0 if parsing fails
        }
    }
}
