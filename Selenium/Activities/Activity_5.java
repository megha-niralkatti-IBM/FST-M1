package Activity_CRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_5 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//input[@id=\"bigbutton\"]")).click();
        WebElement color = driver.findElement(By.xpath("//div[@id=\"toolbar\"]"));
        String bgcolor = color.getCssValue("color");
        System.out.println("--bgclour--" +bgcolor);
        driver.quit();

    }

}
