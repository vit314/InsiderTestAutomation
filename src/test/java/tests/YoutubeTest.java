package tests;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class YoutubeTest extends Base {

    @Test
    public void youtubeTest() throws InterruptedException {

        driver.get("https://www.youtube.com/");
        Thread.sleep(3000);

        WebElement element = driver.findElement(By.xpath("//input[@id='search']"));

        element.sendKeys("Тестирование");

        Thread.sleep(3000);
        element.submit();

        Thread.sleep(3000);
        WebElement vent = driver.findElement(By.xpath("//yt-formatted-string[contains(@aria-label,'Тестировщик с нуля')]"));
        vent.click();

        Thread.sleep(20000);
    }
}
