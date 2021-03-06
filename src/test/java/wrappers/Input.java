package wrappers;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class Input {
    String label;
    String locator = "//*[contains(text(), '%s')]/following-sibling::input";

    public Input(String label) {
        this.label = label;
    }

    public Input write(String text) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        $x(String.format(locator, label)).shouldBe(visible).sendKeys(text);
        return this;
    }

    public Input clear() {
        $x(String.format(locator, label)).shouldBe(visible).clear();
        return this;
    }

    public void shouldHave(String text) {
        $x(String.format(locator, label)).shouldHave(Condition.attribute("value", text));
    }
}
