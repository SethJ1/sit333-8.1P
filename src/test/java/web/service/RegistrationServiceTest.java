package web.service;

import org.junit.Assert;
import org.junit.Test;

public class RegistrationServiceTest {

    @Test
    public void testRegisterSuccess() {
        boolean result = RegistrationService.register("Seth", "Johnson", "seth@example.com", "2000-01-01");
        Assert.assertTrue(result);
    }

    @Test
    public void testRegisterFailureEmptyFields() {
        boolean result = RegistrationService.register("", "", "", "");
        Assert.assertFalse(result);
    }

    @Test
    public void testRegisterFailureInvalidEmail() {
        boolean result = RegistrationService.register("John", "Johnson", "invalid-email", "2000-01-01");
        Assert.assertFalse(result);
    }

    @Test
    public void testRegisterFailureNullFields() {
        boolean result = RegistrationService.register(null, null, null, null);
        Assert.assertFalse(result);
    }

    @Test
    public void testRegisterFailureMissingFirstName() {
        boolean result = RegistrationService.register("", "Johnson", "seth@example.com", "2000-01-01");
        Assert.assertFalse(result);
    }

    @Test
    public void testRegisterFailureMissingLastName() {
        boolean result = RegistrationService.register("Seth", "", "seth@example.com", "2000-01-01");
        Assert.assertFalse(result);
    }

    @Test
    public void testRegisterFailureMissingEmail() {
        boolean result = RegistrationService.register("Seth", "Johnson", "", "2000-01-01");
        Assert.assertFalse(result);
    }

    @Test
    public void testRegisterFailureMissingDob() {
        boolean result = RegistrationService.register("Seth", "Johnson", "seth@example.com", "");
        Assert.assertFalse(result);
    }
}
