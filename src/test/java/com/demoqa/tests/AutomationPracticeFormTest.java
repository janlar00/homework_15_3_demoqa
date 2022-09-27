package com.demoqa.tests;

import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

import java.io.File;

public class AutomationPracticeFormTest {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Petrov");
        $("#userEmail").setValue("Ivan.Petrov@test.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").selectOption("1970");
        $(".react-datepicker__day--001:not(.react-datepicker__day--selected").click();
        $x("//input[@id='subjectsInput']").setValue("Arts").pressEnter();
        $(By.xpath("//div[@id='hobbiesWrapper']//label[contains(text(),'Music')]")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/Test.jpg"));
        $("#currentAddress").setValue("Some address 1");
        $x("//input[@id='react-select-3-input']").setValue("NCR").pressEnter();
        $x("//input[@id='react-select-4-input']").setValue("Gurgaon").pressEnter();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Ivan Petrov"),
                text("Ivan.Petrov@test.com"),
                text("Male"),
                text("1234567890"),
                text("01 February,1970"),
                text("Arts"),
                text("Music"),
                text("img/Test.jpg"),
                text("Some address 1"),
                text("NCR Gurgaon"));
        // $("#closeLargeModal").click();
    }
}
