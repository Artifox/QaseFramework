package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pageobjects.LoginPage;
import pageobjects.ProjectsPage;

import static com.codeborne.selenide.Condition.visible;

public class LoginSteps {

    LoginPage loginPage;


    //Todo: Инициализировать пэйджи в конструкторе или в методе?
    public LoginSteps() {
        loginPage = new LoginPage();
    }

    @Step("Login by user: {email}")
    public ProjectSteps login(String email, String password) {
        loginPage
                .open()
                .successfulLogin(email, password);
        return new ProjectSteps();
    }

}
