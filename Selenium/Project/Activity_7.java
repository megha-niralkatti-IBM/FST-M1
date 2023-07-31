package Activity_CRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Activity_7 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//input[@id=\"bigbutton\"]")).click();
        driver.findElement(By.id("grouptab_0")).click();
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*='index%26parentTab%3DSales'][id='moduleTab_9_Leads']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='oddListRowS1'][1]/td[10]"))).click();

        Thread.sleep(3000);
        Actions builder = new Actions(driver);
        //Locate the popup
        WebElement popupElement = driver.findElement(By.xpath("//span[@class='phone']")); // Replace with the appropriate locator for the popup element
        builder.moveToElement(popupElement).build().perform();
// Retrieve the text or content of the popup
        String tooltipMessage = popupElement.getText();
        System.out.println("Mobile:" + tooltipMessage);
        driver.close();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='listViewBody']")));
        //driver.switchTo().activeElement();
        //WebElement modalContainer = driver.findElement(By.id("//*[@id=\"ui-id-7\"]"));
        //System.out.println("done");
        //WebElement modalContentBody = modalContainer.findElement(By.id("//*[@id=\"ui-id-7\"]"));
        //Assert.assertEquals(modalContentBody.getText(), "This is the place where the content for the modal dialog displays", "Verify modal body message");

        //driver.switchTo().activeElement();
        //System.out.println(driver.getTitle());
        //driver.close();


        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'suitepicon suitepicon-action-info') and @title='Additional Details']"))).click();
        //WebElement baseTable = driver.findElement(By.xpath("//table[@class =\"list view table-responsive\"]"));

        //To find third row of table
        //WebElement tableRow = baseTable.findElement(By.xpath("//*[@class='oddListRowS1'][1]"));
        //String rowtext = tableRow.getText();
        //System.out.println("Third row of table : "+rowtext);

        //to get 3rd row's 2nd column data
        //WebElement cellIneed = tableRow.findElement(By.xpath("//*[@class='oddListRowS1'][1]/td[10]"));
        //cellIneed.click();

// Store the alert in a variable
        //Alert alert = driver.switchTo().alert();
        //System.out.println("done");

// Print the text from the alert
        //System.out.println(alert.getText());

// Click the OK button on the alert
       // alert.accept();



        //driver.findElement(By.xpath("//span[contains(@class,'suitepicon suitepicon-action-info') and @title='Additional Details']"));



    }

}
