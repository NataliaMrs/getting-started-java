package tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWorkNewTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Novikov");
        $("#userEmail").setValue("alex@novikov.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("7912345211");
        //$("#dateOfBirthInput").setValue("17 Jul 2012");
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

    void checkFirstLastnameTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());

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