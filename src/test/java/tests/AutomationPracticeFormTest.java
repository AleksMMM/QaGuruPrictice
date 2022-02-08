package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import readProperties.ConfigProvider;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTest {

        @BeforeAll
        static void beforeAll() {
            Configuration.baseUrl = "https://demoqa.com";
            Configuration.browserSize = "1920x1080";
        }

        @Test
        @DisplayName("Проверка заполнения формы")
        void successFillFormTest() {
            open("/automation-practice-form");
            $(".main-header").shouldHave(text("Practice Form"));

            // Заполнение полей
            $("#firstName").setValue("Buryak");
            $("#lastName").setValue("Borsh");
            $("#userEmail").setValue("soup@mymom.com");
            $(byText("Other")).click();
            $("#userNumber").setValue("1234567890");
            $("#dateOfBirthInput").click();
            $(".react-datepicker__year-select").selectOption("2000");
            $(".react-datepicker__month-select").selectOption("December");
            $(byText("6")).click();
            $("#subjectsInput").setValue("english");
            $(byText("English")).click();
            $(byText("Sports")).click();
            $(byText("Reading")).click();
            $(byText("Music")).click();
            $("#uploadPicture").uploadFile(new File("src/main/resources/picture.jpg"));
            $("#currentAddress").setValue("Dharmapuri, Forest Colony, Tajganj, Agra, Uttar Pradesh 282001, India");
            $("#stateCity-label").scrollTo();
            $(byText("Select State")).click();
            $(byText("NCR")).click();
            $(byText("Select City")).click();
            $(byText("Delhi")).click();
            $("#submit").click();

            //Проверки что поля были заполнены верно:
            $(".table-responsive").shouldHave(text("Buryak Borsh"));
            $(".table-responsive").shouldHave(text("soup@mymom.com"));
            $(".table-responsive").shouldHave(text("Other"));
            $(".table-responsive").shouldHave(text("06 December,2000"));
            $(".table-responsive").shouldHave(text("English"));
            $(".table-responsive").shouldHave(text("Sports"));
            $(".table-responsive").shouldHave(text("Reading"));
            $(".table-responsive").shouldHave(text("Music"));
            $(".table-responsive").shouldHave(text("picture.jpg"));
            $(".table-responsive").shouldHave(text("Dharmapuri, Forest Colony, Tajganj, Agra, Uttar Pradesh 282001, India"));
            $(".table-responsive").shouldHave(text("NCR Delhi"));

        }
}
