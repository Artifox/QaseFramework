package tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    public static final String EMAIL = "qasetestako@mailinator.com";
    public static final String PASSWORD = "qasetestako@mailinator.com";

    @Test
    public void login(){
        welcomePage
                .open()
                .pressLoginButton()
                .successfulLogin(EMAIL, PASSWORD)
                .createNewProjectButtonShouldPresentOnPage();
    }
}
