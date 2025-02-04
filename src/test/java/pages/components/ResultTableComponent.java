package pages.components;

import com.codeborne.selenide.SelenideElement;

import pages.RegistrationFormPage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {

    private final SelenideElement resultTable = $(".table-responsive"),
            resultTitle = $("#example-modal-sizes-title-lg");



    public ResultTableComponent checkTable(String key, String value) {
        resultTable.$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }

    public ResultTableComponent checkTitleMissing() {
        resultTitle.shouldNotBe(visible);
        return this;
    }

    public ResultTableComponent checkTitle() {
        resultTitle.shouldHave(exactText("Thanks for submitting the form"));
        return this;
    }
}