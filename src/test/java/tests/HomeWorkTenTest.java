package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import static io.qameta.allure.Allure.step;

public class HomeWorkTenTest {

    private static final String SELENIDE = "selenide/selenide";
    private static final String NUMBER = "#3000";

    @Test
    void  searchIssuesTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("Ищем" + SELENIDE, () -> {
            $(".search-input").click();
            $("#query-builder-test").setValue(SELENIDE).submit();
                });

        step("Кликаем по ссылке" + SELENIDE, () -> {
        $(linkText(SELENIDE)).click();
        });

        step("Открываем Issues" , () -> {
        $("#issues-tab").click();
        });

        step("Проверяем наличие  issues с"  +  NUMBER, () -> {
        $("ul .MainContent-module__container--ry4iL").shouldHave(text(NUMBER));
        });
    }

    @Test
    void  searchIssuesAnnotaionTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebStepsTen stepss = new WebStepsTen();

        stepss.openMainPage();
        stepss.searchSelenide(SELENIDE);
        stepss.clickOnSelenide(SELENIDE);
        stepss.checkNumber(NUMBER);





    }
    }

