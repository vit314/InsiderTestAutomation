package pages;

import base.Base;
import base.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import java.util.List;

public class CareersPage extends Base {

  Util util = new Util();

  public CareersPage(WebDriver driver) {
    this.driver = driver;
    AjaxElementLocatorFactory ajaxElementLocatorFactory = new AjaxElementLocatorFactory(driver, 60);
    PageFactory.initElements(ajaxElementLocatorFactory, this);
  }


  @FindBy(xpath = "//h3[contains(text(),'Our Locations')]")
  WebElement ourLocationsItem;

  @FindBy(xpath = "//a[text()='See all teams']")
  WebElement seeAllTeamsButton;

  @FindBy(xpath = "//div[contains(@class,'job-title')]")
  List<WebElement> jobsTitlesList;

  @FindBy(xpath = "//h2[text()='Life at Insider']")
  WebElement lifeAtInsiderButton;

  @FindBy(xpath = "//div[@class='location-info']")
  List<WebElement> locationsList;

  @FindBy(xpath = "//p[contains(text(),'We’re here to grow and drive growth—as none of us ')]")
  WebElement lifeAtInsiderText;

  @FindBy(xpath = "//h3[text()='Quality Assurance']")
  WebElement qualityAssuranceItem;


  public void verifyCareersPage(String expectedUrl, String expectedTitle) {
    Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Url is not correct");
    Assert.assertEquals(driver.getTitle(), expectedTitle, "Title is not correct");
    Assert.assertTrue(ourLocationsItem.isDisplayed(), "Our Locations item is not displayed");
    Assert.assertTrue(seeAllTeamsButton.isDisplayed(), "See all teams button is not displayed");
    Assert.assertTrue(lifeAtInsiderButton.isDisplayed(), "Life at ther Insider button is not displayed");
    System.out.println("Careers page is displayed correctly");
  }

  public void clickOnSeeAllTeams() {
    util.waitForElementClickable(driver, seeAllTeamsButton, 20);
    util.scrollTo(driver, seeAllTeamsButton);
    util.clickByJs(driver, seeAllTeamsButton);
  }

  public void clickOnQualityAssurance() {
    util.scrollTo(driver, qualityAssuranceItem);
    util.waitForElementClickable(driver, qualityAssuranceItem, 20);
    util.clickByJs(driver, qualityAssuranceItem);
  }

  public void checkJobsTitles() {
    Assert.assertTrue(jobsTitlesList.size() != 0, "There is no jobs list present");
    System.out.println("There is job list present");
  }

  public void checkLifeAtInsiderText() {
    Assert.assertTrue(lifeAtInsiderText != null, "There is no Life at Insider text displayed");
    System.out.println("Text for Life at Insider is present");
  }

  public void checkLocations() {
    Assert.assertTrue(locationsList.size() != 0, "There are no locations displayed");
    System.out.println("Locations are diplayed");
  }
}