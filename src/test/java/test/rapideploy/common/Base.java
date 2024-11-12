package test.rapideploy.common;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Base {

    public static RemoteWebDriver driver;

    FileReader reader;
    Properties properties;
    protected String url;



    public static RemoteWebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setup() throws IOException {
        try {
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            readProperties();
            goToUrl();
        } catch (Exception e) {
            System.out.println("Failed to load browser: " + e.getMessage());
        }
    }

    public void readProperties() throws IOException {
        reader = new FileReader("config.properties");
        properties = new Properties();

        properties.load(reader);
        url = properties.getProperty("url");
        reader.close();
    }

    public void goToUrl() {
        driver.get(url);
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        driver.quit();
    }
}