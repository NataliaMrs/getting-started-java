package tests;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class WebStepsTen {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий {repo}")
    public void searchSelenide(String repo) {
        $(".search-input").click();
        $("#query-builder-test").setValue(repo).submit();
    }

    @Step("Кликаем по ссылке {repo}")
    public void clickOnSelenide(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Проверяем наличие  issues с {number}")
    public void checkNumber(String number) {
        $("ul .MainContent-module__container--ry4iL").shouldHave(text(number));
    }
}
