package Activity_CRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_2 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
        WebElement img = driver.findElement(By.xpath("//img[@alt=\"SuiteCRM\"]"));
        String src = img.getAttribute("src");
        System.out.println("url of the header image " +src);
        driver.close();
    }
}
