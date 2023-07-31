package Activity_CRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity_9 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//input[@id=\"bigbutton\"]")).click();
        driver.findElement(By.id("grouptab_0")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*='index%26parentTab%3DSales'][id='moduleTab_9_Leads']"))).click();

        Thread.sleep(3000);
        List allRows= driver.findElements(By.xpath("//*[@class='list view table-responsive']/tbody/tr"));
        System.out.println("Total odd data rows found in table:" +allRows.size());

        for (int i = 0; i < allRows.size(); i ++) { // Increment i by 2 to access odd-numbered rows
            WebElement row = (WebElement) allRows.get(i); // Explicitly cast the WebElement to resolve the incompatible types error
            String name = row.findElement(By.xpath(".//td[3]")).getText(); // Assuming the name is in the third column (td[3])
            String user = row.findElement(By.xpath(".//td[8]")).getText();
            System.out.println("Name: " + name + " user: " +user);

            // Stop after printing the names of the first 5 odd-numbered rows
            if (i >= 9) {
                break;
            }
        }

        driver.quit();

    }
}
