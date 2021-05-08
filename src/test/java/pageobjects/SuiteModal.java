package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import models.Suite;
import wrappers.Button;
import wrappers.Input;
import wrappers.MirrorInput;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SuiteModal extends BaseModalPage {

    private SelenideElement createSuiteLabel = $x("//*[contains(text(),'Create suite')]");
    private SelenideElement createButton = $("#save-suite-button");

    @Override
    public SuiteModal isOpened() {
        createSuiteLabel.shouldBe(Condition.visible);
        return this;
    }

    public RepositoryPage createNewSuite(Suite suite) {
        new Input("Suite name").write(suite.getName());
        new MirrorInput("Description").write(suite.getDescription());
        new MirrorInput("Preconditions").write(suite.getPreconditions());
        createButton.click();
        return new RepositoryPage();
    }
}
