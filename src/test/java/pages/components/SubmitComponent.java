package pages.components;

import com.codeborne.selenide.SelenideElement;

import pages.RegistrationFormPage;

import static com.codeborne.selenide.Selenide.$;

public class SubmitComponent {

    private SelenideElement submit =  $("#submit");

    public void submit () {
        submit.click();
    }

}
