package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import models.Case;
import wrappers.Button;
import wrappers.Dropdown;
import wrappers.Input;
import wrappers.MirrorInput;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CreateNewCasePage extends BasePage {
    private SelenideElement createTestCaseLabel = $x("//*[contains(text(), 'Create test case')]");
    private SelenideElement saveCaseButton = $("#save-case");

    @Override
    public CreateNewCasePage isOpened() {
        createTestCaseLabel.shouldBe(Condition.visible);
        return this;
    }

    public CreateNewCasePage open(String projectCode) {
        Selenide.open("/case/" + projectCode + "/create");
        return this;
    }

    @Deprecated
    @Override
    public BasePage open() throws Exception {
        throw new Exception("You are using deprecated method");
    }

    public RepositoryPage createCase(Case aCase) {
        fillCaseFields(aCase);
        saveCaseButton.click();
        return new RepositoryPage();
    }

    private void fillCaseFields(Case aCase) {
        try {
            new Input("Title").clear().write(aCase.getTitle());
            Thread.sleep(500);
            new MirrorInput("Description").clear().write(aCase.getDescription());
            Thread.sleep(500);
            new Dropdown("Status").setDropdown(aCase.getStatus());
            Thread.sleep(500);
            new Dropdown("Severity").setDropdown(aCase.getSeverity());
            Thread.sleep(500);
            new Dropdown("Priority").setDropdown(aCase.getPriority());
            Thread.sleep(500);
            new Dropdown("Type").setDropdown(aCase.getType());
            Thread.sleep(500);
            new Dropdown("Layer").setDropdown(aCase.getLayer());
            Thread.sleep(500);
            new Dropdown("Is Flaky").setDropdown(aCase.getIsFlaky());
            Thread.sleep(500);
            new Dropdown("Behavior").setDropdown(aCase.getBehavior());
            Thread.sleep(500);
            new Dropdown("Automation status").setDropdown(aCase.getAutomationStatus());
            Thread.sleep(500);
            new MirrorInput("Pre-conditions").clear().write(aCase.getPreConditions());
            Thread.sleep(500);
            new MirrorInput("Post-conditions").clear().write(aCase.getPostConditions());
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public RepositoryPage updateCase(Case aCase) {
        return createCase(aCase);
    }

    public RepositoryPage validateCaseFields(Case aCase) {
        new Input("Title").shouldHave(aCase.getTitle());
        new MirrorInput("Description").shouldHave(aCase.getDescription());
        new Dropdown("Status").shouldHave(aCase.getStatus());
        new Dropdown("Severity").shouldHave(aCase.getSeverity());
        new Dropdown("Priority").shouldHave(aCase.getPriority());
        new Dropdown("Type").shouldHave(aCase.getType());
        new Dropdown("Layer").shouldHave(aCase.getLayer());
        new Dropdown("Is Flaky").shouldHave(aCase.getIsFlaky());
        new Dropdown("Behavior").shouldHave(aCase.getBehavior());
        new Dropdown("Automation status").shouldHave(aCase.getAutomationStatus());
        new MirrorInput("Pre-conditions").shouldHave(aCase.getPreConditions());
        new MirrorInput("Post-conditions").shouldHave(aCase.getPostConditions());
        new Button("Cancel").click();
        new Button("Close form").click();
        return new RepositoryPage();
    }
}
