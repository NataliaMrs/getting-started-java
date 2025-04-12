package pages.components;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import pages.RegistrationFormPage;

import static com.codeborne.selenide.Selenide.$;

public class UploadComponent {

    private SelenideElement  uploadFile =  $("#uploadPicture");

    public void uploadFile (String value) {
        uploadFile.uploadFromClasspath(value);
    }
}
