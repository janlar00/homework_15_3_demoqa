package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import com.demoqa.SetUp;
import com.demoqa.testData.UserInformation;

import org.junit.jupiter.api.Test;

public class RegistrationFormWithPageObjectsTest extends SetUp {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName(UserInformation.firstName)
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

    }

}