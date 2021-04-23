package pageobjects;

import wrappers.Button;
import wrappers.Input;

public class LoginPage {

    public LoginPage errorLogin(String email, String password){
        new Input("Email").write(email);
        new Input("Password").write(password);
        new Button("Login").click();
        return this;
    }
    public ProjectsPage successfulLogin(String email, String password){
        errorLogin(email, password);
        return new ProjectsPage();
    }
}
