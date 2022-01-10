package core;


import cucumber.api.java.After;
import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import steps.Hooks;

import java.io.File;
import java.io.IOException;

public class DriverFactory {
    private static WebDriver driver;

    private DriverFactory() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (Propriedades.browser) {
                case FIREFOX:
                    System.setProperty("webdriver.gecko.driver", "src/drivers/geckodriver");
                    driver = new FirefoxDriver();
                    break;
                case CHROME:
                    System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver");
                    driver = new ChromeDriver();
                    break;
            }
            //driver.manage().window().setSize(new Dimension(1200, 765));
        }
        return driver;
    }

    public static void killDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
