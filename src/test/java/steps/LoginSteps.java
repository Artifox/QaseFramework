package steps;

import io.qameta.allure.Step;
import pageobjects.LoginPage;

public class LoginSteps {

    LoginPage loginPage;


    //Todo: Инициализировать пэйджи в конструкторе или в методе?
    public LoginSteps() {
        loginPage = new LoginPage();
    }

    @Step("Logging in by user: {email}")
    public void login(String email, String password) {
        loginPage
                .open()
                .successfulLogin(email, password)
                .isOpened();
    }

}
