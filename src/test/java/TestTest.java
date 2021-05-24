import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestTest {

    AppiumDriver driver;
    DesiredCapabilities capabilities = new DesiredCapabilities();

    @BeforeClass
    public void setup() throws MalformedURLException {
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("fullReset", "false");
        capabilities.setCapability("deviceName", "sdk-gphone");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        capabilities.setCapability( "automationName", "UiAutomator2");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(url, capabilities);
    }

    @Test
    public void practiceTest() {

        MobileElement two = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/androidx.slidingpanelayout.widget.SlidingPaneLayout/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.Button[8]"));
        MobileElement plus = (MobileElement) driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"plus\"]"));
        MobileElement equals = (MobileElement) driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"equals\"]"));
        MobileElement output = (MobileElement) driver.findElement(By.className("android.widget.TextView"));

        two.click();
        plus.click();
        two.click();
        equals.click();

        String sum = output.getText();

        assert(Integer.parseInt(sum) == 4);
    }

}
