package pages;

import base.Base;
import base.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;


public class HomePage extends Base {

  Util util = new Util();

  public HomePage(WebDriver driver) {
    this.driver = driver;
    AjaxElementLocatorFactory ajaxElementLocatorFactory = new AjaxElementLocatorFactory(driver, 60);
    PageFactory.initElements(ajaxElementLocatorFactory, this);
  }

  @FindBy(xpath = "//span[text()='More']")
  WebElement moreMenu;

  @FindBy(xpath = "//h5[text()='Careers']")
  WebElement careersSection;


  public void verifyHomePage(String expectedUrl, String expectedTitle) {
    util.waitForPageLoaded(driver);
    Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Url is not correct");
    Assert.assertEquals(driver.getTitle(), expectedTitle, "Title is not correct");
    Assert.assertTrue(moreMenu.isDisplayed(), "More menu item is not displayed");
    System.out.println("HomePage is displayed correctly");
  }

  public void clickOnMoreMenu() {
    util.clickElement(moreMenu, "More menu item");
  }

  public void clickOnCareers() {
    util.clickElement(careersSection, "Careers block");
  }
}