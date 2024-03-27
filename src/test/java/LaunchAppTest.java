import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class LaunchAppTest {
    public static void main(String[] args) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("automationName","uiautomator2");
        desiredCapabilities.setCapability("udid","emulator-5554");
        desiredCapabilities.setCapability("appPackage","com.wdiodemoapp");
        desiredCapabilities.setCapability("appActivity","com.wdiodemoapp.MainActivity");

        //Create appium sever
        AppiumDriver appiumDriver = null;
        //Init session
        try{
            URL appiumSever = new URL("http://localhost:4723");
            //appiumSever la noi minh muon gui den
            //desired la cai minh muon gui
            appiumDriver = new AndroidDriver(appiumSever,desiredCapabilities);
        } catch (Exception e){
            e.printStackTrace();
        }




        //Close session
        /* Neu appium khong null thi quit */
        if (appiumDriver !=null) {
            appiumDriver.quit();
        }

    }
}
