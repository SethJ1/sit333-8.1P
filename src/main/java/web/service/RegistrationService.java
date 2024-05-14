package web.service;

/**
 * Business logic to handle registration functions.
 */
public class RegistrationService {

    public static boolean register(String fName, String lName, String email, String dob) {
        // Check for empty fields
        if (fName == null || fName.isEmpty() ||
            lName == null || lName.isEmpty() ||
            email == null || email.isEmpty() ||
            dob == null || dob.isEmpty()) {
            return false;
        }

        // Check for valid email format
        if (!email.contains("@") || !email.contains(".")) {
            return false;
        }

        System.out.println("First name: " + fName);
        System.out.println("Last name: " + lName);
        System.out.println("Email: " + email);
        System.out.println("DoB (yyyy-mm-dd): " + dob);

        return true;
    }
}
