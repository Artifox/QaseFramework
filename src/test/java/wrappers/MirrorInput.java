package wrappers;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MirrorInput {
    String label;
    String locator = "//*[contains(text(), '%s')]/parent::div/descendant::p[@class='empty-node']";
    String parent = "//*[contains(text(), '%s')]/following-sibling::input/preceding-sibling::div";

    public MirrorInput(String label) {
        this.label = label;
    }

    public void setFocus() {
        $x(String.format(parent, label)).click();
    }

    public void write(String text) {
        setFocus();
        $x(String.format(locator, label)).shouldBe(visible).sendKeys(text);
    }
}
