package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {

    @Before(value = "@Chrome")
    public void setupChrome() {
        Driver.instance.startBrowser();
    }

    @Before(value = "@ChromeHeadless")
    public void setupChromeHeadless() {
        Driver.instance.startBrowserHeadless();
    }

    @After
    public void tearDown() {
        Driver.instance.stopBrowser();
    }
}
