package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SauceLabsBackpack extends Base {

  public SauceLabsBackpack(WebDriver driver) {
    AjaxElementLocatorFactory ajaxElementLocatorFactory = new AjaxElementLocatorFactory(driver, 60);
    PageFactory.initElements(ajaxElementLocatorFactory, this);
  }

  private By addToCartButton = By.xpath("//button[text()='ADD TO CARTS']");
  private By cartButton = By.xpath("//div[@id='shopping_cart_container']/a/s");

  //"Click \"ADD TO CART\" button on the Sauce Labs Backpack page"
  public void clickAddToCartButton() {
    driver.findElement(addToCartButton).click();
  }

  //"Click Cart icon on the Sauce Labs Backpack page"
  public void clickCartButton() {
    driver.findElement(cartButton).click();
  }
}