package com.gmail.romkrasko.tests;

import org.openqa.selenium.WebDriver;
import com.gmail.romkrasko.core.BrowserFactory;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import static com.gmail.romkrasko.core.BrowserFactory.*;

public class BaseTest {

    @BeforeClass
    public WebDriver start() {
        driver = BrowserFactory.getInstance();
        return driver;

    }

    @AfterClass
    protected void tearDown() {
        BrowserFactory.falling();
    }
}
