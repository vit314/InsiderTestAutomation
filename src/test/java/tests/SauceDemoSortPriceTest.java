package tests;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoSortPriceTest extends Base {

    @Test
    public void sauceDemoSortPriceTest() throws InterruptedException {

        openPage();

        loginBase();

        WebElement sortPriceLowToHigh = driver.findElement(By.xpath("//select[@class='product_sort_container']//option[@value='lohi']"));
        sortPriceLowToHigh.click();

        Assert.assertEquals(getPriceItemsFromPage(), sortPriceLowToHigh());

    }
}
