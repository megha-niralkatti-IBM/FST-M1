package Activity_CRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity_1 {
    @Test
    public void testAssertFunctions() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
        System.out.println("done");
        String ExpectedString = driver.getTitle();
        System.out.println(ExpectedString);
        String ActualString = "SuiteCRM";
        System.out.println("DONE2");
        Assert.assertEquals(ExpectedString, ActualString);
        driver.close();
    }


}
