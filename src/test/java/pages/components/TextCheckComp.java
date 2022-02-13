package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TextCheckComp {

    public void checkText(String locator, String field, String value) {
        $(locator).$(byText(field)).parent().shouldHave(text(value));
    }
}
