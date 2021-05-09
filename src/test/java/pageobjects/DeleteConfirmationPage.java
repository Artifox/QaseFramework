package pageobjects;

import wrappers.Button;

import static com.codeborne.selenide.Condition.visible;

public class DeleteConfirmationPage extends BasePage {

    @Override
    public DeleteConfirmationPage isOpened() {
        new Button(" Delete project").shouldBe(visible);
        return this;
    }

    @Deprecated
    @Override
    public BasePage open() {
        return null;
    }

    public ProjectsListPage confirmDeleting() {
        new Button(" Delete project").click();
        return new ProjectsListPage();
    }
}
