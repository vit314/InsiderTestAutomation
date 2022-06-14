package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Finish extends Base {

    public Finish (WebDriver driver) {
    AjaxElementLocatorFactory ajaxElementLocatorFactory = new AjaxElementLocatorFactory(driver, 60);
    PageFactory.initElements(ajaxElementLocatorFactory, this);
  }

  private By gratitudeNotification = By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']");

  //"Return notification with gratitude")
  public String getGratitudeNotification() {
    return driver.findElement(gratitudeNotification).getText();
  }
}