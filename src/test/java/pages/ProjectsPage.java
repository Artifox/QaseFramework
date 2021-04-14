package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProjectsPage{

    private SelenideElement createNewProjectButton = $("#createButton");
    //TODO: Ask "how to return page instance and data from the same method?"
    public ProjectsPage createNewProjectButtonShouldPresentOnPage(){
        createNewProjectButton.shouldBe(visible);
        return this;
    }
}
