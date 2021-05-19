package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import models.Suite;
import wrappers.Input;
import wrappers.MirrorInput;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SuiteModal extends BaseModalPage {

    private SelenideElement createSuiteLabel = $x("//*[contains(text(),'Create suite')]");
    private SelenideElement saveSuiteButton = $("#save-suite-button");

    @Override
    public SuiteModal isOpened() {
        createSuiteLabel.shouldBe(Condition.visible);
        return this;
    }

    public RepositoryPage createNewSuite(Suite suite) {
        fillSuiteFields(suite);
        saveSuiteButton.click();
        return new RepositoryPage();
    }

    public RepositoryPage updateSuite(Suite suite) {
        return createNewSuite(suite);
    }

    private void fillSuiteFields(Suite suite) {
        try {
            Thread.sleep(500);
            new Input("Suite name").clear().write(suite.getName());
            Thread.sleep(500);
            new MirrorInput("Description").clear().write(suite.getDescription());
            Thread.sleep(500);
            new MirrorInput("Preconditions").clear().write(suite.getPreconditions());
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
