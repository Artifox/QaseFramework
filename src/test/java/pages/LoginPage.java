package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement emailField = $("#inputEmail");
    private SelenideElement passwordField = $("#inputPassword");
    private SelenideElement rememberMeCheckbox = $(byName("remember"));
    private SelenideElement loginButton = $("#btnLogin");

    public ProjectsPage successfulLogin(String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
        return new ProjectsPage();
    }
}
