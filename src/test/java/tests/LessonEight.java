package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import data.Language;
import data.gender;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LessonEight {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        //Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @CsvSource(value = {
            " Одежда, Женская одежда",
            "Обувь, Женская обувь",

    })

    @Tag("WEB")
    @DisplayName("Проверка, что открылась верная страница после нжатия на вкладку")
    @ParameterizedTest()
    void openGroupInCatalog (String group, String nameGroup) {

        open("https://www.lamoda.ru/women-home/");
        $$("._root_1416b_2 a").find(text(group)).click();
        $$(".width-wrapper h1").shouldHave(CollectionCondition.texts(nameGroup));
    }




    @EnumSource(gender.class)
    @Tag("WEB")
    @DisplayName("Проверка, что открылась верная страница после нжатия на вкладку")
    @ParameterizedTest()
    void openGroupGenderInCatalog (gender gender) {

        open("https://www.lamoda.ru/women-home/");
        $("nav ._root_1mtda_2").$$("a").find(text(gender.name())).click();
        $$("_iconsBanner_edqtv_61 _row_edqtv_7").shouldHave(CollectionCondition.texts(gender.description
        ));
    }

    @EnumSource(Language.class)
    @ParameterizedTest
    @DisplayName("Проверка смены языка заголовка")
    void displayCorrectText(Language chooseLanguage) {
        open("https://yandex.com/support2/metro/en/");
        $(".g-popover__handler button", 1).click();
        $$(".g-popup_open button").find(text(chooseLanguage.name())).click();
        $(".dc-doc-page__content h1").shouldHave(text(chooseLanguage.headerText));
    }

    @ValueSource(strings = {
            "163571936",
            "175440928"
    })
    @ParameterizedTest(name = "После нажатия на кнопку 'В избраное' должно появится модальное окно с выбором размера")
    @Tag("WEB")
    void checkModalWindowWithSizesIfNoGoods(String articleNumber) {
        open("https://www.wildberries.ru/");
        $("#searchInput").click();
        $("#searchInput").setValue(articleNumber).pressEnter();
        $(".product-params__table").shouldHave(text(articleNumber));
        $(".order__for-fixed", 1).shouldHave(text("В избранное")).click();
        $(".popup__header").shouldHave(text("Выберите размер"));
    }


}
