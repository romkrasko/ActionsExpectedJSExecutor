package com.gmail.romkrasko.tests;

import com.gmail.romkrasko.pages.OnlinerPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.gmail.romkrasko.core.BrowserFactory.*;


public class JSExecTest extends BaseTest {
    public static OnlinerPage onlinerPage;

    @BeforeClass
    protected void initiliaze() {
        onlinerPage = new OnlinerPage(driver);
    }

    @Test
    public void jsExecTest(){
        onlinerPage.sendToInputExecutor();
        onlinerPage.clickRefreshButtonExecutor();
    }
}