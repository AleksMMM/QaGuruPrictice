package pages.components;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationPage {

    // components
    private TextComp textComponent = new TextComp();
    private PlaceholderComp placeholderComponent = new PlaceholderComp();
    private CalendarComp calendarComponent = new CalendarComp();
    private TextContainerComp textContainerComponent = new TextContainerComp();
    private UploadFileComp uploadFileComponent = new UploadFileComp();
    private LinePlaceholderComp linePlaceholderComponent = new LinePlaceholderComp();
    private TextCheckComp textCheckComponent = new TextCheckComp();

    // locators
    private String
            page = "/automation-practice-form",
            firstNameInput = "#firstName",
            lastNameInput = "#lastName",
            emailInput = "#userEmail",
            mobileNumberInput = "#userNumber",
            calendarInput = "#dateOfBirthInput",
            monthInput = ".react-datepicker__month-select",
            yearInput = ".react-datepicker__year-select",
            dayInput = ".react-datepicker__week ",
            subjectInput = "#subjectsInput",
            fileInput = "#uploadPicture",
            addressInput = "#currentAddress",
            stateInput = "#state",
            cityInput = "#city",
            submitButton = "#submit",
            resultsTable = ".table-responsive";

    // actions
    public StudentRegistrationPage openPage() {
        open(page);

        return this;
    }

    public StudentRegistrationPage setFirstName(String firstName) {
        textComponent.insertValue(firstNameInput, firstName);

        return this;
    }

    public StudentRegistrationPage setLastName(String lastName) {
        textComponent.insertValue(lastNameInput, lastName);

        return this;
    }

    public StudentRegistrationPage setEmail(String email) {
        textComponent.insertValue(emailInput, email);

        return this;
    }

    public StudentRegistrationPage setGender(String gender) {
        placeholderComponent.clickOn(gender);

        return this;
    }

    public StudentRegistrationPage setMobileNumber(String mobileNumber) {
        textComponent.insertValue(mobileNumberInput, mobileNumber);

        return this;
    }

    public StudentRegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarComponent.setDate(calendarInput, monthInput, yearInput, dayInput, month, year, day);

        return this;
    }

    public StudentRegistrationPage setSubjects(String subject) {
        textContainerComponent.insertValue(subjectInput, subject);

        return this;
    }

    public StudentRegistrationPage setHobbies(String hobby) {
        placeholderComponent.clickOn(hobby);

        return this;
    }

    public StudentRegistrationPage uploadPicture(String fileName) {
        uploadFileComponent.uploadFile(fileInput, fileName);

        return this;
    }

    public StudentRegistrationPage setAddress(String address) {
        textComponent.insertValue(addressInput, address);

        return this;
    }

    public StudentRegistrationPage setState(String state) {
        linePlaceholderComponent.clickOnLine(stateInput, state);

        return this;
    }

    public StudentRegistrationPage setCity(String city) {
        linePlaceholderComponent.clickOnLine(cityInput, city);

        return this;
    }

    public StudentRegistrationPage clickSubmit() {
        $(submitButton).click();

        return this;
    }

    public StudentRegistrationPage checkForm(String fieldName, String value) {
        textCheckComponent.checkText(resultsTable, fieldName, value);

        return this;
    }
}
