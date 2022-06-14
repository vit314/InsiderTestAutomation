package tests;

import base.Base;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import data.UserData;
import pages.HomePage;
import pages.LoginPage;

public class SortTests extends Base {

  @Test
  @Description(value = "Test sorts product items from A to Z by alphabetic")
  public void nameAtoZ() {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.login(UserData.userNameLogin, UserData.userPassword);
    homePage.clickSortContainerAtoZButton();
    Assert.assertEquals(homePage.getItemsSuiteString(), homePage.notSortedItemList());
  }

  @Test
  @Description(value = "Test sorts product items from Z to A by alphabetic")
  public void nameZtoA() {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.login(UserData.userNameLogin, UserData.userPassword);
    homePage.clickSortContainerZtoAButton();
    Assert.assertEquals(homePage.getItemsSuiteString(), homePage.sortListZToA());
  }

  @Test
  @Description(value = "Test sorts product items by price from low to high")
  public void priceLowToHigh() {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.login(UserData.userNameLogin, UserData.userPassword);
    homePage.clickPriceLowToHighButton();
    Assert.assertEquals(homePage.getPriceItemsFromPage(), homePage.sortPriceLowToHigh());
  }

  @Test
  @Description(value = "Test sorts product items by price from high to low")
  public void priceHighToLow() {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.login(UserData.userNameLogin, UserData.userPassword);
    homePage.clickPriceHighToLowButton();
    Assert.assertEquals(homePage.getPriceItemsFromPage(), homePage.sortPriceHighToLow());
  }
}
