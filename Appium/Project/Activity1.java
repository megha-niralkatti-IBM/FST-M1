package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {
    AndroidDriver driver;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    }

    // Test method
    @Test
    public void addtaskTest() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        Thread.sleep(3000);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.apps.tasks:id/add_task_title");
        //driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Tasks");
        WebElement task1 = driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title"));
        task1.sendKeys("Complete Activity with Google Tasks");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

        Thread.sleep(3000);
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        Thread.sleep(3000);
        //driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Keep");
        WebElement task2 = driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title"));
        task2.sendKeys("Complete Activity with Google Keep");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        Thread.sleep(3000);

        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        Thread.sleep(3000);
        WebElement task3 = driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title"));
        task3.sendKeys("Complete the second Activity Google Keep");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

        //Assert.assertEquals(task3, "Complete the second Activity Google Keep");



    }



}
