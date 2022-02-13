package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LinePlaceholderComp {

    public void clickOnLine(String locator, String text) {
        $(locator).click();
        $(byText(text)).click();
    }
}
