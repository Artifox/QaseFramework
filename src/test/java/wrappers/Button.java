package wrappers;

import static com.codeborne.selenide.Selenide.$x;

public class Button {
    String label;
    String locator = "//*[contains(@class, 'btn') and contains(text(), '%s')]";
    //"Create new project"

    public Button (String label){
        this.label = label;
    }

    public void click(){
        $x(String.format(locator, label)).click();
    }
}
