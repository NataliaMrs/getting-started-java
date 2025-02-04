package tests;


import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;
import utils.TestData;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static utils.TestData.*;

public class HomeWorkSevenTest extends TestBase {

    RegistrationFormPage registrationPage = new RegistrationFormPage();
    TestData testData = new TestData();




    @Test
    void fillFormPOTest() {
        registrationPage.openPage()
                        .setFirstName(firstNamee)
                        .setLastName(lastNamee)
                        .setEmail(userEmaile)
                        .chooseGender(gendere)
                        .setPhone(phonee)
                        .setDateOfBirth(birthMonthe,  birthYeare)
                        .setSubjects(subjectse)
                        .chooseHobbies(hobbiese)
                        .uploadPicture(picturee)
                        .setAddress(addresse)
                        .chooseState(statee)
                        .chooseCity(citye)
                        .clickSubmit();

        registrationPage.checkResult("Student Name", "Alex Novikov")
                .checkResult("Student Email", userEmaile)
                .checkResult("Gender", gendere)
                .checkResult("Mobile", phonee)
                .checkResult("Date of Birth", "21 July,2008")
                .checkResult("Subjects", subjectse)
                .checkResult("Hobbies", hobbiese)
                .checkResult("Picture", "jv.png")
                .checkResult("Address", addresse)
                .checkResult("State and City", "NCR Delhi");;

    }

    @Test
    void fillFormPOFakerTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .chooseGender(testData.gender)
                .setPhone(testData.phone)
                .setDateOfBirth(testData.birthMonth,  testData.birthYear)
                .setSubjects(testData.subjects)
                .chooseHobbies(testData.hobbies)
                .uploadPictures(testData.picture)
                .setAddress(testData.address)
                .chooseState(testData.state)
                .chooseCity(testData.city)
                .clickSubmit();

        registrationPage.checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.userEmail )
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.phone)
                .checkResult("Date of Birth", "21" + " " +  testData.birthMonth + "," + testData.birthYear)
                .checkResult("Subjects",testData.subjects)
                .checkResult("Hobbies", testData.hobbies)
                .checkResult("Picture", testData.picture)
                .checkResult("Address", testData.address)
                .checkResult("State and City", testData.state + " " + testData.city);

    }

    @Test

    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Novikov");
        $("#userEmail").setValue("alex@novikov.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("7912345211");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("2015");
        $(".react-datepicker__day.react-datepicker__day--021").click();
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("ma");
        $(byText("Maths")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("/Users/nataliavasilenko/IdeaProjects/getting-started-java/src/test/resources/jv.png"));
        $("#currentAddress").setValue("Address my");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Student Name Alex Novikov"));
        $(".table-responsive").shouldHave(text("Student Email alex@novikov.com"));
        $(".table-responsive").shouldHave(text("Gender Male"));
        $(".table-responsive").shouldHave(text("Mobile 7912345211"));
        $(".table-responsive").shouldHave(text("Date of Birth 21 June,2015"));
        $(".table-responsive").shouldHave(text("Subjects Maths"));
        $(".table-responsive").shouldHave(text("Hobbies Sports"));
        $(".table-responsive").shouldHave(text("Picture jv.png"));
        $(".table-responsive").shouldHave(text("Address Address my"));
        $(".table-responsive").shouldHave(text("State and City NCR Delhi"));
        $("#closeLargeModal").click();

    }

    @Test

    void  checkMinDatePOTest() {

          registrationPage.openPage()
                  .setFirstName("Alex")
                  .setLastName("Novikov")
                  .chooseGender("Male")
                  .setPhone("7912345211")
                  .setDateOfBirth("July", "2008")
                  .clickSubmit();

        registrationPage.checkTitles()
                        .checkResult("Student Name", "Alex Novikov")
                        .checkResult("Gender", "Male")
                        .checkResult("Mobile", "7912345211")
                        .checkResult("Date of Birth", "21 July,2008");
    }

    @Test

    void  checkMinDateTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Novikov");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("7912345211");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("2015");
        $(".react-datepicker__day.react-datepicker__day--021").click();
        executeJavaScript("$('footer').remove()");
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Student Name Alex Novikov"));
        $(".table-responsive").shouldHave(text("Gender Male"));
        $(".table-responsive").shouldHave(text("Mobile 7912345211"));
        $(".table-responsive").shouldHave(text("Date of Birth 21 June,2015"));

    }

    @Test

    void checkFirstLastnamePOTest() {

        registrationPage.openPage()
                .chooseGender("Male")
                .setPhone("7912345211")
                .setDateOfBirth("July", "2008")
                .clickSubmit();

        registrationPage.checks();



    }

    @Test

    void checkFirstLastnameTest() {

        open("/automation-practice-form");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("7912345211");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("2015");
        $(".react-datepicker__day.react-datepicker__day--021").click();
        executeJavaScript("$('footer').remove()");
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldNotBe(visible);

    }
}