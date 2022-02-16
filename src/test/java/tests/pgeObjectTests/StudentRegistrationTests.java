package tests.pgeObjectTests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.components.StudentRegistrationPage;

public class StudentRegistrationTests {
    Faker faker = new Faker();
    private StudentRegistrationPage registrationPage = new StudentRegistrationPage();
    private String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = "Male",
            mobileNumber = faker.phoneNumber().phoneNumber(),
            day = "1",
            dayCheck = "01",
            month = "January",
            year = "2000",
            subject = "Maths",
            hobby = "Sports",
            picture = "picture.jpg",
            address = "Ulica, dom 1",
            state = "NCR",
            city = "Delhi";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void FillFormTest() {
        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setMobileNumber(mobileNumber)
                .setDateOfBirth(day, month, year)
                .setSubjects(subject)
                .setHobbies(hobby)
                .uploadPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit()

                //Checking the correctness of filling out the form
                .checkForm("Student Name", firstName + " " + lastName)
                .checkForm("Student Email", email)
                .checkForm("Gender", gender)
                .checkForm("Mobile", mobileNumber)
                .checkForm("Date of Birth", dayCheck + " " + month + "," + year)
                .checkForm("Subjects", subject)
                .checkForm("Hobbies", hobby)
                .checkForm("Picture", picture)
                .checkForm("Address", address)
                .checkForm("State and City", state + " " + city);
    }
}
