package tests;

import driver.DriverFactory;
import driver.Platform;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected AppiumDriver appiumDriver;

    @BeforeTest
    @Parameters({"systemPort", "udid"})
    public void initAppiumDriverSession(String systemPort, String udid) {
        if (appiumDriver == null) {
            appiumDriver = DriverFactory.getDriver(Platform.ANDROID, systemPort, udid);
        }
    }

    @AfterTest(alwaysRun = true)
    public void quitAppiumDriverSession() {
        if (appiumDriver != null) {
            appiumDriver.quit();
        }
    }

}