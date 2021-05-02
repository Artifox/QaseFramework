package pageobjects;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import wrappers.Button;
import wrappers.Input;

import static com.codeborne.selenide.Condition.visible;

public class LoginPage extends BasePage {

    public LoginPage errorLogin(String email, String password) {
        new Input("Email").write(email);
        new Input("Password").write(password);
        new Button("Login").click();
        return this;
    }

    @Step("Filling login form")
    public ProjectsListPage successfulLogin(String email, String password) {
        errorLogin(email, password);
        return new ProjectsListPage();
    }

    //Todo: Можно ли здесь возвращать страницу или лучше булин?
    @Override
    public LoginPage isOpened() {
        new Button("Login").shouldBe(visible);
        return this;
    }

    @Step("Opening 'Login' page")
    @Override
    public LoginPage open() {
        Selenide.open("/login");
        return this;
    }
}
