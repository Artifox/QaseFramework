package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;

public class LoginTest extends BaseTest{
    public static final String EMAIL = "qasetestako@mailinator.com";
    public static final String PASSWORD = "qasetestako@mailinator.com";

    @Test
    public void login(){
        welcomePage
                .open()
                .pressLoginButton()
                .successfulLogin(EMAIL, PASSWORD)
                .createNewProjectButtonShouldBe(visible);
    }
}
