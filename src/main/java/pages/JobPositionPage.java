package pages;

import base.Base;
import base.Util;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import java.util.ArrayList;

public class JobPositionPage extends Base {

  Util util = new Util();

  public JobPositionPage(WebDriver driver) {
    this.driver = driver;
    AjaxElementLocatorFactory ajaxElementLocatorFactory = new AjaxElementLocatorFactory(driver, 60);
    PageFactory.initElements(ajaxElementLocatorFactory, this);
  }


  @FindBy(xpath = "//a[contains(text(),'Apply for this job')]")
  WebElement applyForThisJobButton;

  @FindBy(xpath = "//div[contains(text(),'Istanbul, Turkey')]")
  WebElement positionIstanbul;

  @FindBy(xpath = "//div[contains(text(),'Quality Assurance')]")
  WebElement positionQa;


  public void verifyJobPositionPage() {

    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));

    Assert.assertTrue(applyForThisJobButton.isDisplayed(), "Apply for this job button is not displayed");
    Assert.assertTrue(positionIstanbul.isDisplayed(), "Istanbul position is not displayed");
    Assert.assertTrue(positionQa.isDisplayed(), "Quality Assurance scope is not displayed");
    System.out.println("Page is displayed correctly");
  }
}