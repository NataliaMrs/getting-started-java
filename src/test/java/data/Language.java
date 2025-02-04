package data;

public enum Language {

    English("What is Yandex Metro?"),
    Russian("Что такое Яндекс Метро");


    public final String headerText;

    Language(String headerText) {
        this.headerText = headerText;
    }
}
