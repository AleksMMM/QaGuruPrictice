package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class TextComp {

    public void insertValue(String locator, String text) {
        $(locator).setValue(text);
    }
}
