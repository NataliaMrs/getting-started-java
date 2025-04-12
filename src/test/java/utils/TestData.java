package utils;

import com.github.javafaker.Faker;
import pages.RegistrationFormPage;

import java.util.Locale;

public class TestData {

    public static String firstNamee = "Alex",
            lastNamee = "Novikov",
            userEmaile = "alex@novikov.com",
            gendere = "Male",
            phonee = "7912345211",
            birthMonthe  = "July",
            birthYeare = "2008",
            subjectse = "Maths",
            hobbiese = "Sports",
            picturee = "jv.png",
            addresse = "Address my",
            statee = "NCR",
            citye = "Delhi";

    private static Faker faker = new Faker(new Locale("en-GB"));

    public String firstName = getRandomFirstName(),
            lastName = getRandomLastName(),
            userEmail = getRandomUserEmail(),
            gender = getRandomGender(),
            phone = getRandomPhone(),
            birthMonth = getRandomBirthMonth(),
            birthYear = getRandomBirthYear(),
            subjects = getRandomSubjects(),
            hobbies = getRandomHobbies(),
            picture = getRandomPicture(),
            address = getRandomAddress(),
            state = getRandomState(),
            city = getRandomCity(state);


    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomUserEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomGender() {
        return faker.options().option("Male", "Female", "Other");
//        String[] genders = {"Male", "Female", "Other"};
//        return getRandomItemFromArray(genders);
    }

    public static String getRandomPhone() {
        return faker.number().digits(10);

    }

    public static String getRandomBirthMonth() {
        String[] month = {"December", "January", "February", "March",
                "April", "May", "June", "July",
                "August", "September", "October", "November"};
        return faker.options().option(month);

    }

    public static String getRandomBirthYear() {
        return String.valueOf(faker.number().numberBetween(2000, 2020));

    }

    public static String getRandomSubjects() {
        return faker.options().option("Arts", "Maths", "History");

    }

    public static String getRandomHobbies() {
        return faker.options().option("Sports", "Reading", "Music");

    }

    public static String getRandomPicture() {
        return faker.options().option("jv.png", "jv1.png", "jv2.png");

    }

    public static String getRandomAddress() {
        return faker.address().fullAddress();

    }

    public static String getRandomState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

    }

    public static String getRandomCity(String state) {
        String city = "";
        if (state.equals("NCR")) city = faker.options().option("Delhi", "Gurgaon", "Noida");
        if (state.equals("Uttar Pradesh")) city = faker.options().option("Agra", "Lucknow", "Merrut");
        if (state.equals("Haryana")) city = faker.options().option("Karnal", "Panipat");
        if (state.equals("Rajasthan")) city = faker.options().option("Jaipur", "Jaiselmer");
        return city;

    }





}
