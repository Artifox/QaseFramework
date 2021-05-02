package pageobjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class WelcomePage {

    private SelenideElement loginButton = $("#signin");

    public WelcomePage open() {
        Selenide.open("/");
        return this;
    }

    public LoginPage pressLoginButton() {
        loginButton.click();
        return new LoginPage();
    }
}
