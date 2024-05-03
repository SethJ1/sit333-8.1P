package web.service;

import java.time.LocalDate;

/**
 * Business logic to handle login functions.
 * 
 * @author Ahsan.
 */
public class LoginService {

    /**
     * Static method to authenticate user login.
     * 
     * @param username The username entered by the user.
     * @param password The password entered by the user.
     * @param dob      The date of birth entered by the user (format: yyyy-mm-dd).
     * @return true if the login is successful, false otherwise.
     */
    public static boolean login(String username, String password, String dob) {
        // Retrieve the current date
        LocalDate currentDate = LocalDate.now();

        // Parse the date of birth string to LocalDate object
        LocalDate dobDate = LocalDate.parse(dob);

        // Assuming a minimum age requirement for login, e.g., 18 years
        LocalDate minAllowedDob = currentDate.minusYears(18);

        // Check if the username and password match and the user is of legal age
        if ("ahsan".equals(username) && "ahsan_pass".equals(password) && dobDate.isBefore(minAllowedDob)) {
            return true; // Authentication successful
        }

        return false; // Authentication failed
    }
}
