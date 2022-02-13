package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComp {

    public void setDate(String locator, String locatorMonth, String locatorYear, String locatorDay, String month, String year, String day) {
        $(locator).click();
        $(locatorMonth).selectOption(month);
        $(locatorYear).selectOption(year);
        $(locatorDay).$(byText(day)).click();
    }
}
