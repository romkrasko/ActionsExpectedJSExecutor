package com.gmail.romkrasko.pages;

import com.gmail.romkrasko.core.WaiterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;


public class OnlinerPage {
    private Actions actions;
    private JavascriptExecutor js;
    public OnlinerPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.actions =  new Actions(driver);
        this.js = (JavascriptExecutor)driver;
    }

    public WebDriver driver;
    WaiterClass waiter = new WaiterClass();

    @FindBy(css = ".b-update-btn-1")
    public WebElement refreshButton;

    @FindBy(css = ".b-pages")
    public WebElement pagesPanel;

    @FindBy(css = ".fast-search__input")
    public WebElement searchInput;





    public void clickRefreshButton(){
        waiter.WaitUntilElementIsEnable(refreshButton);
        actions.moveToElement(refreshButton);
        actions.perform();
        actions.click(refreshButton);
        actions.perform();
        waiter.simpleWait(1000);
    }

    public void scrollDown(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(pagesPanel));
        actions.moveToElement(pagesPanel);
        actions.perform();
        waiter.simpleWait(1000);
        actions.moveToElement(pagesPanel);
        actions.perform();
        waiter.simpleWait(1000);
    }

    public void sendToInputAction(){
        waiter.WaitUntilElementIsEnable(searchInput);
        actions.moveToElement(searchInput);
        actions.perform();
        actions.click(searchInput);
        actions.perform();
        actions.sendKeys("test string");
        actions.perform();
        waiter.simpleWait(1000);
    }
    public void sendToInputExecutor(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementsByClassName('fast-search__input')[0].value='123'");
        waiter.simpleWait(1000);
        js.executeScript("arguments[0].click();", refreshButton);
        waiter.simpleWait(1000);
    }

    public void clickRefreshButtonExecutor(){
        js.executeScript("arguments[0].click();", refreshButton);
        waiter.simpleWait(1000);
    }





}

