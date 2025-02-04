package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;
import pages.components.SubmitComponent;
import pages.components.UploadComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    CalendarComponent calendar = new CalendarComponent();
    UploadComponent upFile = new UploadComponent();
    SubmitComponent submitComponent = new SubmitComponent();
    ResultTableComponent resultTableComponent = new ResultTableComponent();

    private SelenideElement firstNameInput = $("#firstName"),
                            lastNameInput = $("#lastName"),
                            emailInput = $("#userEmail"),
                            gender = $("#genterWrapper"),
                            phone = $("#userNumber"),
                            dateBirth = $("#dateOfBirthInput"),
                            subject = $("#subjectsInput"),
                            hobbies = $("#hobbiesWrapper"),
                            address = $("#currentAddress"),
                            state =  $("#state"),
                            city = $("#city");

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationFormPage chooseGender(String value) {
        gender.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setPhone(String value) {
        phone.setValue(value);

        return this;
    }

    public RegistrationFormPage setDateOfBirth(String month, String year) {
        dateBirth.click();
        calendar.setDate(month, year);

        return this;
    }

    public RegistrationFormPage setSubjects(String value) {
//        subject.click();
//        subject.setValue("ma");
//        $(byText(value)).click();
        subject.setValue(value).pressEnter();

        return this;
    }

    public RegistrationFormPage chooseHobbies(String value) {
        hobbies.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage uploadPicture(String value) {
        upFile.uploadFile(value);

        return this;
    }

    public RegistrationFormPage uploadPictures(String value) {
        upFile.uploadFile(value);

        return this;
    }

    public RegistrationFormPage setAddress(String value) {
        address.setValue(value);

        return this;
    }

    public RegistrationFormPage chooseState(String value) {
        state.click();
        $(byText(value)).click();

        return this;
    }

    public RegistrationFormPage chooseCity(String value) {
        city.click();
        $(byText(value)).click();

        return this;
    }

    public RegistrationFormPage clickSubmit() {
        submitComponent.submit();

        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultTableComponent.checkTable(key,value);

        return this;
    }

    public RegistrationFormPage checks() {
        resultTableComponent.checkTitleMissing();

        return this;
    }

    public RegistrationFormPage checkTitles() {
        resultTableComponent.checkTitle();

        return this;
    }



}
