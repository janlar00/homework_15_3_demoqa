package com.demoqa;

import org.junit.jupiter.api.BeforeAll;

import com.codeborne.selenide.Configuration;

public class SetUp {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }
}
