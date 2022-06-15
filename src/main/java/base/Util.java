
package base;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import base.Base;

public class Util extends Base {

    public void openPage(String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(3000);
        driver.findElement(By.id("wt-cli-accept-all-btn")).click();
    }

    public void clickElement(WebElement element, String elementName) {
        System.out.println("Click by action: " + element);
        try {
            element.click();
        } catch (Exception e) {
            throw new NoSuchElementException("Can't click on " + elementName + ". " + e.getMessage());
        }
    }

    public void waitForPageLoaded(WebDriver driver) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                        .equals("complete");
            }
        };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    public void selectUsingVisibleText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void scrollTo(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickByJs(WebDriver driver, WebElement element) {
        System.out.println("Click by js: " + element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void waitForElementClickable(WebDriver driver, WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            Assert.fail("Failed timeout wait element to be clickable - " + e.getMessage());
        }
    }
}
