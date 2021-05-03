package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void login() {
        loginSteps
                .login(EMAIL, PASSWORD);
    }

    /*@Test
    public void failTest() {
        loginSteps.login(EMAIL, PASSWORD);
        Assert.fail();
    }*/
}
