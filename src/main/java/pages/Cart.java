package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class Cart extends Base {
  public Cart(WebDriver driver) {
    AjaxElementLocatorFactory ajaxElementLocatorFactory = new AjaxElementLocatorFactory(driver, 60);
    PageFactory.initElements(ajaxElementLocatorFactory, this);
  }

  private By checkoutButton = By.xpath("//a[@class='btn_action checkout_button']");
  private By removeButton = By.xpath("//div[@class='cart_list']/div[@class='cart_item'][1]//button[text()='REMOVE']");
  private By removeButtons = By.xpath("//button[@class='btn_secondary cart_buttons']");
  private By listOfItems = By.xpath("//div[@class='cart_item']");
  private By continueShoppingButton = By.xpath("//a[text()='Continue Shoppingl']");

  //"Delete one product item from the cart by clicking \"REMOVE\" button"
  public void removeOneItemFromCart() {
    driver.findElement(removeButton).click();
  }

  //"Delete all items from the cart by clicking button \"REMOVE\" near every product item"
  public void removeAllItemsFromCart() {
    List<WebElement> removeButtonsList = driver.findElements(removeButtons);
    for (int i = 0; i < removeButtonsList.size(); i++) {
      removeButtonsList.get(i).click();
    }
  }

  public int listOfItems() {
    List<WebElement> items = driver.findElements(listOfItems);
    return items.size();
  }

  //"Click \"CHECKOUT\" button on the Cart page"
  public void clickCheckoutButton() {
    driver.findElement(checkoutButton).click();
  }

  //"Click \"CONTINUE SHOPPING\" button on the Cart page"
  public void clickContinueShoppingButton() {
    driver.findElement(continueShoppingButton).click();
  }
}