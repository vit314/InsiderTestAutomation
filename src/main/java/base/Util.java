
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

    protected WebDriverWait wait;
    Long maxWaitTimeToFindElement = 20L;

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

    public void waitForElementVisibility(WebDriver driver, WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            String currentIframe = getCurrentFrameName(driver);
            Assert.fail(
                    "Current iframe - " + currentIframe + ". Failed wait for element visibility - " + e.getMessage());
        }
    }

    public String getCurrentFrameName(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return jsExecutor.executeScript("return self.name").toString();
    }

    public boolean isElementVisibility(WebDriver driver, By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void waitForElementInvisibility(WebDriver driver, WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {
            Assert.fail("Failed timeout wait of element invisibility - " + e.getMessage());
        }
    }

    public void waitForElementVisibility(WebDriver driver, By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            Assert.fail("Failed timeout wait of element visibility - " + e.getMessage());
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

    public void selectByVisibleValue(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByValue(text);
    }

    public void scrollTo(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickByJs(WebDriver driver, WebElement element) {
        System.out.println("Click by js: " + element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void hover(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void hoverAndClick(WebDriver driver, WebElement elementToHover, WebElement elementToClick) {
        Actions action = new Actions(driver);
        action.moveToElement(elementToHover).click(elementToClick).build().perform();
    }
}
