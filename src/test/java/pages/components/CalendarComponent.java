package pages.components;

import pages.RegistrationFormPage;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDate (String month, String year) {

        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day.react-datepicker__day--021").click();
    }
}
