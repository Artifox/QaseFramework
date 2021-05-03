package wrappers;

import static com.codeborne.selenide.Selenide.$x;

public class RadioButton {
    String option;
    String locator = "//*[contains(@type, 'radio') and contains(@value,'%s')]";

    public RadioButton(String option) {
        this.option = option;
    }

    public void setRadioButton() {
        $x(String.format(locator, option)).click();
    }
}
