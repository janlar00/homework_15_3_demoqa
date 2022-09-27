package com.demoqa.testData;

import java.util.Locale;

import com.demoqa.utils.Month;
import com.github.javafaker.Faker;

public class UserInformation {

    private static final Faker faker = new Faker(new Locale("de-CH"));

    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.demographic().sex(),
            number = faker.phoneNumber().subscriberNumber(10),
            day = String.valueOf(faker.number().numberBetween(10, 31)),
            month = String.valueOf(Month.getRandomMonth()),
            year = String.valueOf(faker.number().numberBetween(1900, 2001)),
            subjects = "Hindi",
            hobbies = "Music",
            picturePath = "src/test/resources/img/Test.jpg",
            picture = "Test.jpg",
            address = faker.address().fullAddress(),
            state = "Uttar Pradesh",
            city = "Lucknow",
            birthDay = day + " " + month + "," + year;
}