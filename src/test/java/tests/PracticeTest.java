package tests;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeTest extends Base {

    @Test
    public void practiceTest() throws InterruptedException {

        driver.get("https://selectorshub.com/xpath-practice-page/");
        Thread.sleep(3000);

        String titleActual = driver.getTitle();
        String titleExpected = "XPath & cssSelector Practice Page with all scenarios – SelectorsHub";

        Assert.assertEquals(titleActual, titleExpected);


//
//        WebElement userEmail = driver.findElement(By.id("userId"));
//        userEmail.sendKeys("test@test.com");
//        Thread.sleep(3000);
//
//        WebElement password = driver.findElement(By.id("pass"));
//        password.sendKeys("pass123");
//        Thread.sleep(3000);
//
//        WebElement company = driver.findElement(By.name("company"));
//        company.sendKeys("qa company");
//        Thread.sleep(3000);
//
//        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
//        submit.click();
//        Thread.sleep(3000);


    }
}
