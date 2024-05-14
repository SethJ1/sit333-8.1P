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
    	// Check if emtpy
        if (dob.isEmpty()) {
            return false;
        }
    	
        // Retrieve the current date
        LocalDate currentDate = LocalDate.now();

        // Parse the date of birth string to LocalDate object
        LocalDate dobDate = LocalDate.parse(dob);

        // Check if the username, password and dob match
        if ("ahsan".equals(username) && "ahsan_pass".equals(password) && dobDate.equals(LocalDate.of(2002, 1, 1))) {
            return true; // Authentication successful
        }

        return false; // Authentication failed
    }
}
