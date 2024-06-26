package practice;

import driver.DriverFactory;
import driver.Platform;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestSwipingVertically {
    public static void main(String[] args) {
        AppiumDriver appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {
            By formBtnLoc = AppiumBy.accessibilityId("Swipe");
            By activeBtnLoc = AppiumBy.accessibilityId("button-Active");

            // Navigate to [Forms] screen
            appiumDriver.findElement(formBtnLoc).click();

            // Swipe up before interacting
            Dimension windowSize = appiumDriver.manage().window().getSize();
            int screenWidth = windowSize.getWidth();
            int screenHeight = windowSize.getHeight();

            // Constructor coordinators
            int startX = 10 * screenWidth / 100;
            int startY = 95 * screenHeight / 100;
            int endX = startX;
            int endY = 10 * screenHeight / 100;
            boolean isFoundElement = false;
            By foundEleLoc = AppiumBy.xpath("//android.widget.ScrollView[@content-desc=\"Swipe-screen\"]/android.view.ViewGroup/android.widget.TextView");
            List<WebElement> elementList = appiumDriver.findElements(foundEleLoc);
            while (!isFoundElement){
                if (!elementList.isEmpty()){
                    for (WebElement element : elementList) {
                        if ((element.getText()).equals("You found me!!!")){
                            isFoundElement = true;
                            return;
                        }
                    }
                }
                HandleScrollFeature.scrollScreen(appiumDriver, startX, endX, startY, endY);
                elementList = appiumDriver.findElements(foundEleLoc);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        // DEBUG PURPOSE ONLY
        try {
            Thread.sleep(3000);
        } catch (Exception ignored) {
        }
        appiumDriver.quit();
    }
}
