package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class UploadFileComp {

    public void uploadFile(String locator, String fileName) {
        $(locator).uploadFromClasspath(fileName);
    }
}
