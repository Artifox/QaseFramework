package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProjectsPage{

    private SelenideElement createNewProjectButton = $("#createButton");

    //TODO: Ask "how to return page instance and data from the same method?"
    //TODO: Ask how to write error messages in shouldBe
    public ProjectsPage createNewProjectButtonShouldBe(Condition condition){
        createNewProjectButton.shouldBe(condition);
        return this;
    }
}
