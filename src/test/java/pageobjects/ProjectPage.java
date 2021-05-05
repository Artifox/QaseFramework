package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectPage extends BasePage {

    private String header = "//*[contains(text(),'%s')]";

    public ProjectPage isOpened(String projectName) {
        $x(String.format(header, projectName))
                .shouldBe(Condition.exactText(projectName));
        return this;
    }

    public ProjectPage open(String name) {
        Selenide.open("/project/" + name);
        return null;
    }

    @Deprecated
    @Override
    public ProjectPage isOpened() {
        return this;
    }

    @Deprecated
    @Override
    public ProjectPage open() {
        try {
            throw new Exception("This method is deprecated");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
