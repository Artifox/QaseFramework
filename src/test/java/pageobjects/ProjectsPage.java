package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProjectsPage extends BasePage{

    private SelenideElement createNewProjectButton = $("#createButton");

    @Override
    public ProjectsPage isOpened() {
        createNewProjectButton.shouldBe(Condition.visible);
        return this;
    }

    @Override
    public ProjectsPage open() {
        Selenide.open("/projects");
        return this;
    }
}
