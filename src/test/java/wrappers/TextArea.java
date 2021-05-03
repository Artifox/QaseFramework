package wrappers;

import static com.codeborne.selenide.Selenide.$x;

public class TextArea {
    String label;
    String locator = "//*[contains(text(), '%s')]/following-sibling::textarea";

    public TextArea(String label) {
        this.label = label;
    }

    public void write(String text) {
        $x(String.format(locator, label)).sendKeys(text);
    }
}
