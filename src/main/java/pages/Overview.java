package pages;

import base.Base;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonIntegerFormatVisitor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Overview extends Base {
  public Overview(WebDriver driver) {
    AjaxElementLocatorFactory ajaxElementLocatorFactory = new AjaxElementLocatorFactory(driver, 60);
    PageFactory.initElements(ajaxElementLocatorFactory, this);
  }

  private By finishButton = By.xpath("//a[@class='btn_action cart_buttons']");
  private By cancelButton = By.xpath("//a[@class='cart_cancel_link btn_secondary']");

  //"Click \"FINISH\" button on the Overview page")
  public void clickFinishButton() {
    driver.findElement(finishButton).click();
  }

  public void clickCancelButton() {
    driver.findElement(cancelButton).click();
  }
}