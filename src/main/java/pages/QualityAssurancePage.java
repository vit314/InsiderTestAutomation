package pages;

import base.Base;
import base.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

public class QualityAssurancePage extends Base {

  Util util = new Util();

  public QualityAssurancePage(WebDriver driver) {
    this.driver = driver;
    AjaxElementLocatorFactory ajaxElementLocatorFactory = new AjaxElementLocatorFactory(driver, 60);
    PageFactory.initElements(ajaxElementLocatorFactory, this);
  }


  @FindBy(xpath = "//a[text()='See all QA jobs']")
  WebElement seeAllQaJobsButton;


  public void verifyQualityAssurancePage(String expectedUrl, String expectedTitle) {
    Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Url is not correct");
    Assert.assertEquals(driver.getTitle(), expectedTitle, "Title is not correct");
    Assert.assertTrue(seeAllQaJobsButton.isDisplayed(), "See all QA jobs button is not displayed");
    System.out.println("QA Page is displayed correctly");
  }

  public void clickOnSeeAllQaJobs() {
    util.clickElement(seeAllQaJobsButton, "See all QA Jobs button");
  }
}