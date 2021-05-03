package wrappers;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class Input {
    String label;
    String locator = "//*[contains(text(), '%s')]/following-sibling::input";

    public Input(String label) {
        this.label = label;
    }

    public void write(String text) {
        $x(String.format(locator, label)).shouldBe(visible).sendKeys(text);
    }
}
