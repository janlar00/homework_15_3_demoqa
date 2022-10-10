package com.demoqa.tests;

import static io.qameta.allure.Allure.step;

import com.demoqa.pages.RegistrationFormPage;
import com.demoqa.BaseTest;
import com.demoqa.testData.UserInformation;

import org.junit.jupiter.api.Test;

public class RegistrationFormWithPageObjectsTest extends BaseTest {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void fillFormTest() {
        step("Open registrations form", () -> {
        registrationFormPage.openPage();
        });
        step("Fill form", () -> {
        registrationFormPage.setFirstName(UserInformation.firstName)
                            .setLastName(UserInformation.lastName)
                            .setEmail(UserInformation.email)
                            .setGender(UserInformation.gender)
                            .setNumber(UserInformation.number)
                            .setBirthDate(UserInformation.day, UserInformation.month, UserInformation.year)
                            .setSubjects(UserInformation.subjects)
                            .setHobbies(UserInformation.hobbies)
                            .uploadFile(UserInformation.picturePath)
                            .setAddress(UserInformation.address, UserInformation.state, UserInformation.city)
                            .clickSubmit();
        });
        step("Check form results", () -> {
        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", UserInformation.firstName + " " + UserInformation.lastName)
                .checkResult("Student Email", UserInformation.email)
                .checkResult("Gender", UserInformation.gender)
                .checkResult("Mobile", UserInformation.number)
                .checkResult("Date of Birth", UserInformation.birthDay)
                .checkResult("Subjects", UserInformation.subjects)
                .checkResult("Hobbies", UserInformation.hobbies)
                .checkResult("Picture", UserInformation.picture)
                .checkResult("Address", UserInformation.address)
                .checkResult("State and City", UserInformation.state + " " + UserInformation.city);
                //.checkResult("State and City", UserInformation.state + " " + UserInformation.hobbies);

        });
    }
}