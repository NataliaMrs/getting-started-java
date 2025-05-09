package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

@Tag("demoqa_n")

public class HomeWorkThree {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        String remote = System.getProperty("remote","123");
        Configuration.remote = remote;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true, //настройки включения видео обе строки
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        closeWebDriver();

    }


    @Test
    void openSoftAssertions() {

        step("Открываем главную страницу", () -> {
        open("");
        });

        step("Проверка", () -> {

        $(".HeaderMenu-nav").$(byText("Solutions")).hover();
        $(byText("Enterprises")).click();
        $$("#hero-section-brand-heading").shouldHave(CollectionCondition.texts("The AI-powered developer platform"));
        });


    }


}
